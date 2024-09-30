package com.example.nestedcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private var counter: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollBtn: Button = findViewById(R.id.rollBtn);

        clearElements();
        rollTheElements();

        rollBtn.setOnClickListener{
            clearElements();
            rollTheElements();
        }
    }

    fun clearElements(){
        var horizontalLayout: LinearLayout = findViewById(R.id.horizontalLayout);
        var verticalLayout: LinearLayout = findViewById(R.id.verticalLayout);
        var constraintLayout: ConstraintLayout = findViewById(R.id.constraintLayout);

        for (view in arrayListOf<ViewGroup>(horizontalLayout, verticalLayout, constraintLayout)){
            for(index in 0..2){
                var textView: TextView = view.getChildAt(index) as TextView;
                textView.setText("-").toString();
            }
        }
    }

    fun rollTheElements(){

        var horizontalLayout: LinearLayout = findViewById(R.id.horizontalLayout);
        var verticalLayout: LinearLayout = findViewById(R.id.verticalLayout);
        var constraintLayout: ConstraintLayout = findViewById(R.id.constraintLayout);

        for (view in arrayListOf<ViewGroup>(horizontalLayout, verticalLayout, constraintLayout)){
            var textView: TextView = view.getChildAt(counter) as TextView;
            textView.setText((counter + 1).toString());
        }

        ++counter;
        if (counter == 3){
            counter = 0;
        }
    }
}