package com.example.appcashparse.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcashparse.data.repository.Repository
import com.example.appcashparse.domain.models.FileCash
import kotlinx.coroutines.launch
import java.io.File

class ViberViewModel: ViewModel() {
    var repository = Repository()
    val viberList: MutableLiveData<List<FileCash>> = MutableLiveData()
    val telegramList: MutableLiveData<List<FileCash>> = MutableLiveData()

    fun getList(){
        viberList.value = repository.getTelegramList()
    }
    fun getListTelegram(){
        telegramList.value = repository.getViberList()
    }
}