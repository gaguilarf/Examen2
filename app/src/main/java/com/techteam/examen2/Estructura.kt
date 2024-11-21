package com.techteam.examen2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader


class Estructura constructor(
    context: Context, attrs: AttributeSet
) : View(context, attrs) {

    val simpleLine = Paint().apply {
        color = Color.BLACK
        isAntiAlias = true
    }

    val puerta = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    val buttonStyle = Paint().apply {
        color = Color.GREEN
        textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 6f, context.resources.displayMetrics)
        isAntiAlias = true
    }

    val buttonRadio = 11f
    private val buttonDraw = ButtonManagment(context)

    init {
        setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val buttonText = buttonDraw.findButton(event.x, event.y)
                if (buttonText != "none") {
                    //aqui va la funcion que recibe el texto del boton
                    Toast.makeText(context, "Clic en botón con texto: $buttonText", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRect(300f, 50f, 600f, 200f, simpleLine)
        canvas.drawRect(100f, 200f, 900f, 500f, simpleLine)

        //puertas
        canvas.drawRect(380f, 45f, 580f, 55f, puerta)
        canvas.drawRect(380f, 195f, 580f, 205f, puerta)

        buttonDraw.draw(canvas)


    }
}