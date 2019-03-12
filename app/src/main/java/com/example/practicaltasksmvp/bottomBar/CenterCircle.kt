package com.example.practicaltasks.views.bottomBar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.example.practicaltasksmvp.R

class CenterCircle @JvmOverloads constructor(context: Context,
                                             attrs: AttributeSet? = null,
                                             defStyleAttr: Int = 0)
    : RelativeLayout(context, attrs, defStyleAttr) {

    private var circleSize: Int
    private var circleColor: Int
    private val paint: Paint = Paint()

    init {
        paint.isAntiAlias = true
        circleSize = resources.getDimension(R.dimen.centre_content_width).toInt()
        circleColor = resources.getColor(R.color.white)
        setWillNotDraw(false)
    }

    fun build(color: Int, size: Int) {
        circleColor = color
        circleSize = size
    }

    override fun onDraw(canvas: Canvas?) {
        paint.color = circleColor
        if (canvas != null){
            canvas.drawCircle(width/2f, height/2f, (circleSize/2).toFloat(), paint)
        }
    }
}