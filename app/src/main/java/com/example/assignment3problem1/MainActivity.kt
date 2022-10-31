package com.example.assignment3problem1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private  lateinit var androidVersionET: EditText
    private  lateinit var codeVersionET: EditText
    private  lateinit var addBtn: Button
    private  lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
    }

    private fun initializeView()
    {
        androidVersionET = findViewById(R.id.evAndroidName)
        codeVersionET = findViewById(R.id.evAndroidCodeName)
        addBtn = findViewById(R.id.btnAdd)
        tableLayout = findViewById(R.id.tableLayout)
    }

    fun btnAddOnClick(view: View)
    {
        val tableRow = TableRow(applicationContext)
        tableRow.setBackgroundColor(getColor(R.color.purple_500))
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT )
        tableRow.layoutParams = layoutParams

        val androidVersion = TextView(this)
        androidVersion.width = getScreenWidth()/2
        androidVersion.setTextColor(getColor(R.color.white))
        androidVersion.text = androidVersionET.text.toString()

        val androidCode = TextView(this)
        androidCode.width = getScreenWidth()/2
        androidCode.setTextColor(getColor(R.color.white))
        androidCode.text = codeVersionET.text.toString()

        tableRow.addView(androidVersion)
        tableRow.addView(androidCode)
        tableLayout.addView(tableRow)

        androidVersionET.text.clear()
        codeVersionET.text.clear()

    }

    private fun getScreenWidth():Int
    {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }
}