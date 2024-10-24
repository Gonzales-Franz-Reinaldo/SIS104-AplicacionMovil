package com.example.proyectokotlin.basedatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.proyectokotlin.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.proyectokotlin.databinding.ActivityMapsBinding


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))


//        val nombre:String? = intent.getStringExtra("nombre")
//        val descripcion:String?  = intent.getStringExtra("descripcion")
//        val latitud: Double = intent.getDoubleExtra("latitud", 0.0)
//        val longitud: Double = intent.getDoubleExtra("longitud", 0.0)
//
//        Log.d("MapsActivity", "Latitud: $latitud, Longitud: $longitud")
//
//        val sucre = LatLng(latitud, longitud)
//        mMap.addMarker(MarkerOptions().position(sucre).title(nombre).snippet(descripcion))
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sucre, 12f))


        // Recuperar los lugares pasados desde RoomActivity
        val lugares: ArrayList<Lugar>? = intent.getParcelableArrayListExtra("lugares")

        if (lugares != null && lugares.isNotEmpty()) {
            // Si hay lugares, los marcamos en el mapa
            for (lugar in lugares) {
                val latLng = LatLng(lugar.latitud, lugar.longitud)
                mMap.addMarker(MarkerOptions().position(latLng).title(lugar.nombre).snippet(lugar.descripcion))
            }
            // Mover la cámara a la primera ubicación de la lista
            val firstLocation = LatLng(lugares[0].latitud, lugares[0].longitud)
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(firstLocation, 12f))

        } else {
            // Si no hay lugares, mostramos el único lugar pasado como datos
            val nombre: String? = intent.getStringExtra("nombre")
            val descripcion: String? = intent.getStringExtra("descripcion")
            val latitud: Double = intent.getDoubleExtra("latitud", 0.0)
            val longitud: Double = intent.getDoubleExtra("longitud", 0.0)

            if (latitud != 0.0 && longitud != 0.0) { // Asegurarse de que las coordenadas sean válidas
                val location = LatLng(latitud, longitud)
                mMap.addMarker(MarkerOptions().position(location).title(nombre).snippet(descripcion))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12f))
            }
        }

    }
}
