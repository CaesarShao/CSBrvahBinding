package com.caesar.brvahbinding.horizontal

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.caesar.brvahbinding.R
import com.caesar.brvahbinding.databinding.ActivityHorlzonBinding

class HorlzonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityHorlzonBinding>(this, R.layout.activity_horlzon)
        val viewModel = HorlzonViewModel()
        binding.vm = viewModel
        viewModel.load()
    }
}
