package com.example.testapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this

        btn_go.setOnClickListener ({
            if (etvName.text.toString().length > 0 && etvAge.text.toString().length > 0 && etvGender.text.toString().length > 0) {
                var info = Info(etvName.text.toString(), etvAge.text.toString().toInt(),etvGender.text.toString())
                var db = DataBaseHandler(context)
                db.insertData(info)
            } else {
                Toast.makeText(context, "You must fill out the form.", Toast.LENGTH_SHORT).show()
            }

        })
    }

}
