package com.caesar.brvahbinding

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.caesar.brvahbinding.databinding.ActivityMainBinding
import com.caesarlib.brvahbinding.CSLog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val model = MainViewModel()
        binding.vm = model
        model.load()
        CSLog.Open()//测试用开启日志
    }
}
