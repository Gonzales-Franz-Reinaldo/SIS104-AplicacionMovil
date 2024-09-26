package com.example.proyectokotlin.ejercicios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonViewModel : ViewModel() {
    private  val _person = MutableLiveData<Person>()
    val person : LiveData<Person> get() = _person

    init{
        _person.value = Person("", "")
    }

    fun apdatePeron(name: String, email: String){
        _person.value = Person(name, email)
    }
}