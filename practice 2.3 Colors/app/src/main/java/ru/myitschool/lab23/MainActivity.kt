package ru.myitschool.lab23

import android.os.Bundle
import ru.myitschool.lab23.databinding.ActivityMainBinding

import android.content.res.Configuration
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val outerLayout = findViewById<LinearLayout>(R.id.outer_layout)

        val currentOrientation = resources.configuration.orientation
        if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
            // Arrange colors vertically
            addColorViewsVertically(outerLayout)
        } else {
            // Arrange colors horizontally
            addColorViewsHorizontally(outerLayout)
        }
    }

    private fun addColorViewsVertically(parentLayout: LinearLayout) {
        val colors = listOf(
            R.color.white, R.color.red, R.color.white,
            R.color.orange, R.color.white, R.color.yellow,
            R.color.white, R.color.green, R.color.white,
            R.color.azure, R.color.white, R.color.blue,
            R.color.white, R.color.violet, R.color.white
        )

        for (color in colors) {
            val colorView = View(this)
            colorView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
            colorView.setBackgroundResource(color)
            parentLayout.addView(colorView)
        }

    }

    private fun addColorViewsHorizontally(parentLayout: LinearLayout) {
        val colors = listOf(
            R.color.white, R.color.red, R.color.white,
            R.color.orange, R.color.white, R.color.yellow,
            R.color.white, R.color.green, R.color.white,
            R.color.azure, R.color.white, R.color.blue,
            R.color.white, R.color.violet, R.color.white
        )

        val horizontalLayout = LinearLayout(this)
        horizontalLayout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        horizontalLayout.orientation = LinearLayout.HORIZONTAL

        for (color in colors) {
            val colorView = View(this)
            val layoutParams = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1f
            )
            layoutParams.marginEnd = 2
            colorView.layoutParams = layoutParams
            colorView.setBackgroundResource(color)
            horizontalLayout.addView(colorView)
        }

        parentLayout.addView(horizontalLayout)
    }

    }