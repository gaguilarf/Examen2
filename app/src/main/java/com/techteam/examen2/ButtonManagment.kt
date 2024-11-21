package com.techteam.examen2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.TypedValue
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

class ButtonManagment(context: Context) {

    private val buttonMap: Map<String, List<ButtonRegion>> = readJson(context)

    //##### INICIO FORMATO BOTONES ####
    //stilo para botones
    private val buttonPaint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    private val buttonText = Paint().apply {
        color = Color.WHITE
        textSize = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            6f,
            context.resources.displayMetrics
        )
        isAntiAlias = true
    }
    //radio boton
    private val buttonRadio = 11f
    //mov del texto respecto al centro del circulo
    private val movX = 10.5f
    private val movY = 7f

    //#### FIN FORMATO BOTONES ####

    fun draw(canvas: Canvas) {
        // Recorre cada espacio y dibuja sus botones
        for ((_, buttonList) in buttonMap) {
            for (button in buttonList) {
                button.draw(canvas)
            }
        }

        /*buttonRetCrucificcion(canvas)
        buttonEsp1(canvas)
        buttonEsp2(canvas)
        buttonEsp3(canvas)
        //retablo principal
        buttonRePrincipal(canvas)
        //coro
        buttonCoro(canvas)
        //retablo de los fundadores botones
        buttonRetFundadores(canvas)
        buttonEsp5(canvas)
        buttonEsp6(canvas)
        buttonEsp7(canvas)
        buttonCapillaIgnacio(canvas)
        buttonAnteSacristiaAnt(canvas)*/
    }

    fun findButton(x: Float, y: Float): String {
        // Recorre cada espacio y cada botón para encontrar el tocado
        for ((_, buttonList) in buttonMap) {
            for (button in buttonList) {
                if (button.contains(x, y)) {
                    // Devuelve el texto
                    return button.text
                }
            }
        }
        return "none" // Devuelve none si no se encontró ningún botón
    }

    private fun readJson(context: Context): Map<String, List<ButtonRegion>> {
        val inputStream = context.resources.openRawResource(R.raw.cords)
        val reader = InputStreamReader(inputStream)

        val gson = Gson()
        val rawMapType = object : TypeToken<Map<String, List<ButtonData>>>() {}.type
        val rawMap = gson.fromJson<Map<String, List<ButtonData>>>(reader, rawMapType)

        reader.close()

        // Convierte el JSON en un Map<String, List<CircleRegion>>
        val circleMap = mutableMapOf<String, List<ButtonRegion>>()
        for ((spaceKey, circles) in rawMap) {
            val circleRegions = circles.map { circleData ->
                ButtonRegion(
                    centerX = circleData.centerX,
                    centerY = circleData.centerY,
                    text = circleData.text,
                    context = context
                )
            }
            circleMap[spaceKey] = circleRegions
        }

        return circleMap
    }
}