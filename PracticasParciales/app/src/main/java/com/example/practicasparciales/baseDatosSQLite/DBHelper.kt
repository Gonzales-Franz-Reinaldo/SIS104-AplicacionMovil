package com.example.practicasparciales.baseDatosSQLite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NOMBRE, null, DATABASE_VERSION){
    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NOMBRE = "personas.db"
        private const val TABLE_NOMBRE = "personas"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NOMBRE = "nombre"
        private const val COLUMN_APELLIDO = "apellido"
        private const val COLUMN_EDAD = "edad"
        private const val COLUMN_SEXO = "sexo"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val createTable = ("CREATE TABLE $TABLE_NOMBRE(" +
                " $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                +" $COLUMN_NOMBRE TEXT, "
                +" $COLUMN_APELLIDO TEXT, "
                +" $COLUMN_EDAD INTEGER, "
                +" $COLUMN_SEXO TEXT)")
        p0?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val dropTable:String = ("DROP TABLE IF EXISTS $TABLE_NOMBRE")
        p0?.execSQL(dropTable)
        onCreate(p0)
    }

    fun insertarPersona(persona: Persona): Long{
        val db: SQLiteDatabase = this.writableDatabase
        val values = ContentValues()

        values.put(COLUMN_NOMBRE, persona.nombre)
        values.put(COLUMN_APELLIDO, persona.apellido)
        values.put(COLUMN_EDAD, persona.edad)
        values.put(COLUMN_SEXO, persona.sexo)

        return db.insert(TABLE_NOMBRE, null, values)
    }


    fun obtenerPersonas():List<Persona>{

        val listaPersonas = ArrayList<Persona>()

        val db: SQLiteDatabase = this.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NOMBRE", null)

        if(cursor.moveToFirst()){
            do {
                val persona = Persona(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                    nombre = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOMBRE)),
                    apellido = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_APELLIDO)),
                    edad = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_EDAD)),
                    sexo = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SEXO))
                )
                listaPersonas.add(persona)
            }while (cursor.moveToNext())
        }

        cursor.close()
        return listaPersonas
    }


    fun editarPersona(persona: Persona): Int {
        val db :SQLiteDatabase = this.writableDatabase

        val values = ContentValues()

        values.put(COLUMN_NOMBRE, persona.nombre)
        values.put(COLUMN_APELLIDO, persona.apellido)
        values.put(COLUMN_EDAD, persona.edad)
        values.put(COLUMN_SEXO, persona.sexo)

        return db.update(TABLE_NOMBRE, values, "$COLUMN_ID = ?", arrayOf(persona.id.toString()))
    }


    fun eliminarPersona(id: Int): Int{
        val db : SQLiteDatabase = this.writableDatabase

        return db.delete(TABLE_NOMBRE, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }
}