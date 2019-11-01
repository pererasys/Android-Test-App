package com.example.testapp
import com.example.testapp.DatabaseHandler
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun storeData(view: View) {
        if (etvName.text.toString().length > 0 && etvAge.text.toString().length > 0 && etvGender.text.toString().length > 0) {
            var info = Info(etvName.text.toString(), etvAge.text.toString().toInt(),etvGender.text.toString())
            var db = DatabaseHandler(this, null, null, 1)
            db.insertData(info)
            etvName.setText("")
            etvAge.setText("")
            etvGender.setText("")
            val intent =  Intent(this, DisplayDataActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "You must fill out the form.", Toast.LENGTH_SHORT).show()
        }

    }

}
