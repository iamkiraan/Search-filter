package com.example.searchfilter

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf

class ViewModel : ViewModel(){

   private val _listsofData = mutableStateListOf("nepal","china","india","usa","indonesia","bangladesh")
    val listofData : List<String> = _listsofData

    fun addata(value : String){
        _listsofData.add(value)
    }

    fun filterData(query : String):List<String>{
        return _listsofData.filter { it.contains(query, ignoreCase = true) }
    }

}