package com.example.appcashparse.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appcashparse.R
import com.example.appcashparse.domain.usecase.CheckandRequestPermission

private val checkPermission by lazy { CheckandRequestPermission() }

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermission.execute(this)//Проверка на разрешение
    }

}
