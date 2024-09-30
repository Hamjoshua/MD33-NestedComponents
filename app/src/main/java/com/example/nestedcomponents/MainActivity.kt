package com.example.nestedcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var progress: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById<Button>(R.id.btn);
        val chb: CheckBox = findViewById<CheckBox>(R.id.chBox);
        val txtView: TextView = findViewById<TextView>(R.id.txtView);
        val editTxt: EditText = findViewById<EditText>(R.id.editTxt);
        val prBar: ProgressBar = findViewById<ProgressBar>(R.id.prBar);

        btn.setOnClickListener{
            if(chb.isChecked){
                val text: String = editTxt.text.toString();
                txtView.setText(text);
                if(progress < 100){
                    progress += 10;
                    prBar.setProgress(progress, true);
                }
            }
        }
    }
}