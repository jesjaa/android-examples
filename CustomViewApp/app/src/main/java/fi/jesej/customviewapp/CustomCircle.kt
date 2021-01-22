package fi.jesej.customviewapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt

// Custom view
class CustomCircle @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @ColorInt
    var color: Int? = Color.RED
    private var paint: Paint = Paint()

    init {
        attrs?.let {
            val styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.CustomCircle)

            // Haetaan attribute value kuvaustiedostosta
            color = styledAttrs.getColor(R.styleable.CustomCircle_customColor, Color.RED)

            styledAttrs.recycle()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Määritellään mitä ruudulle piirretään :)

        // Annetaan väri jos määritelty
        color?.let {
            paint.color = it
        }

        val centerX: Float = (width / 2).toFloat()
        val centerY: Float = (height / 2).toFloat()

        // Nyt piirretään ympyrä "canvasille"
        canvas?.drawCircle(centerX, centerY, 100F, paint)

    }

    fun setCustomColor(@ColorInt color: Int?) {
        this.color = color
    }
}
