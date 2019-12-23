package com.caesar.brvahbinding.loadmore;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.caesar.brvahbinding.R;
import com.caesar.brvahbinding.databinding.ActivityLoadMoreLineBinding;

public class LoadMoreLineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_more_line);
        ActivityLoadMoreLineBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_load_more_line);
        LoadMoreLineViewModel loadMoreLineViewModel = new LoadMoreLineViewModel();
        binding.setVm(loadMoreLineViewModel);
        loadMoreLineViewModel.load();

    }
}
