package com.example.testapp
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast



class DatabaseHandler(context: Context, name:String?,  factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, DATABASE_NAME, factory, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
      val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
              COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
              COL_NAME + " TEXT," +
            COL_AGE + " INTEGER," +
            COL_GENDER + " TEXT)";

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
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

    fun getInfo(): Info? {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        var info: Info? = null

        if (cursor.moveToLast()) {
            cursor.moveToLast()

            val name = cursor.getString(1)
            val age  = Integer.parseInt(cursor.getString(2))
            val gender = cursor.getString(3)
            info = Info(name, age, gender)
            cursor.close()
        }

        db.close()
        return info
    }

    companion object {
        val DATABASE_NAME = "DB"
        val TABLE_NAME = "Info"
        val COL_NAME = "name"
        val COL_AGE = "age"
        val COL_GENDER = "gender"
        val COL_ID = "id"
    }
}