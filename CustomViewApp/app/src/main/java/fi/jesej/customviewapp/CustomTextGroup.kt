package fi.jesej.customviewapp

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout

// compound view group
class CustomTextGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var text: CharSequence
    @DrawableRes
    var icon: Int = 0
    lateinit var placeholder: CharSequence

    init {

        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.custom_text_group, this)

        attrs?.let {
            val styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.CustomTextGroup)

            text = styledAttrs.getString(R.styleable.CustomTextGroup_text).toString()

            icon = styledAttrs.getResourceId(R.styleable.CustomTextGroup_customIcon, 0)

            placeholder = styledAttrs.getString(R.styleable.CustomTextGroup_placeholder).toString()

            styledAttrs.recycle()
        }

        findViewById<TextView>(R.id.tv).text = text
        findViewById<ImageView>(R.id.iv).setImageResource(icon)
        findViewById<EditText>(R.id.et).hint = placeholder

    }


}