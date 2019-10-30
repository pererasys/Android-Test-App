package com.example.testapp
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "DB"
val TABLE_NAME = "Info"
val COL_NAME = "name"
val COL_AGE = "age"
val COL_GENDER = "gender"
val COL_ID = "id"

class DataBaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
      val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
              COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
              COL_NAME + "VARCHAR(256)," +
        COL_AGE + "INTEGER, " +
        COL_GENDER + "VARCHAR(256))";

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(info : Info) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_NAME, info.name)
        cv.put(COL_AGE, info.age)
        cv.put(COL_GENDER, info.gender)
        db.insert(TABLE_NAME, null, cv)
        db.close()
    }
}