package com.example.proyectokotlin.basedatos

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context:Context): SQLiteOpenHelper(context, DATABASE_NOMBRE, null, DATABASE_VERSION){
    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NOMBRE = "lugares.db"
        private const val TABLE_NOMBRE = "lugares"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NOMBRE = "nombre"
        private const val COLUMN_DESCRIPCION = "descripcion"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val createTable = ("CREATE TABLE $TABLE_NOMBRE(" +
                " $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                +" $COLUMN_NOMBRE TEXT, "
                +" $COLUMN_DESCRIPCION TEXT)")
        p0?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val dropTable:String = ("DROP TABLE IF EXISTS $TABLE_NOMBRE")
        p0?.execSQL(dropTable)
        onCreate(p0)
    }
    fun insertarLugar(lugar:Lugar): Long{
        val db:SQLiteDatabase = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NOMBRE, lugar.nombre)
        values.put(COLUMN_DESCRIPCION, lugar.descripcion)
        return db.insert(TABLE_NOMBRE, null, values)
    }
    fun obtenerLugares():List<Lugar>{
        val listaLugares = ArrayList<Lugar>()
        val db:SQLiteDatabase = this.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NOMBRE", null)
        if(cursor.moveToFirst()){
            do {
                val lugar = Lugar(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                    nombre = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOMBRE)),
                    descripcion = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPCION))
                )
                listaLugares.add(lugar)
            }while (cursor.moveToNext())
        }
        cursor.close()
        return listaLugares
    }
    fun editarLugar(lugar: Lugar): Int {
        val db: SQLiteDatabase = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NOMBRE, lugar.nombre)
        values.put(COLUMN_DESCRIPCION, lugar.descripcion)

        // Actualizar la fila
        return db.update(TABLE_NOMBRE, values, "$COLUMN_ID = ?", arrayOf(lugar.id.toString()))
    }

    fun eliminarLugar(id: Int): Int {
        val db: SQLiteDatabase = this.writableDatabase
        // Eliminar la fila
        return db.delete(TABLE_NOMBRE, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }
}