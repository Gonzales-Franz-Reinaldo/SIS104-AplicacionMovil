package com.example.proyectokotlin.basedatos

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable


//import java.io.Serializable
//
//@Entity(tableName = "lugares")
//
//data class Lugar(
//
//    @PrimaryKey(autoGenerate = true)
//    var id: Int,
//    var nombre: String = "",
//    var descripcion: String = "",
//    var latitud: Double = 0.0,
//    var longitud: Double = 0.0
//)


@Entity(tableName = "lugares")
data class Lugar(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var nombre: String = "",
    var descripcion: String = "",
    var latitud: Double = 0.0,
    var longitud: Double = 0.0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeDouble(latitud)
        parcel.writeDouble(longitud)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Lugar> {
        override fun createFromParcel(parcel: Parcel): Lugar {
            return Lugar(parcel)
        }

        override fun newArray(size: Int): Array<Lugar?> {
            return arrayOfNulls(size)
        }
    }
}
