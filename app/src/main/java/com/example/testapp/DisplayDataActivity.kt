package com.example.testapp
import com.example.testapp.DatabaseHandler
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.display_data.*

class DisplayDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_data)
    }
    fun displayData(view: View) {
        var db = DatabaseHandler(this, null, null, 1)
        val info = db.getInfo()
        if (info != null) {
            displayName.text = info.name
            displayAge.text = info.age.toString()
            displayGender.text = info.gender
        } else {
            Toast.makeText(this, "No entry found.", Toast.LENGTH_SHORT).show()
        }


    }

}
