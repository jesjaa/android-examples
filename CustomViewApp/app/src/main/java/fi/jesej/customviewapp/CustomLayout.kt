package fi.jesej.customviewapp

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout

class CustomLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var llContent: LinearLayout?

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.custom_layout, this)

        llContent = findViewById(R.id.content)
    }

    override fun addView(child: View?) {
        if (llContent != null) {
            llContent?.addView(child)
        } else {
            super.addView(child)
        }
    }
}