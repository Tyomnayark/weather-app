package com.tyom.weatherappcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class MainActivityViewModel : ViewModel() {

    private val _temperature = MutableLiveData<String>().apply {
        value = "0"
    }
    val temperature: LiveData<String> = _temperature

    private val _town = MutableLiveData<String>().apply {
        value = ""
    }
    val town: LiveData<String> = _town
}