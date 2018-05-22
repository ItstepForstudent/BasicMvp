package com.itstep.newyorktimesnews.mvp.views;

import android.os.Bundle;
import android.widget.Toast;

import com.itstep.newyorktimesnews.R;
import com.itstep.newyorktimesnews.base.App;
import com.itstep.newyorktimesnews.base.mvp.MvpActivityView;
import com.itstep.newyorktimesnews.mvp.contracts.MainContract;

public class MainActivityView extends MvpActivityView<MainContract.presenter> implements MainContract.view {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.get(this).injector().inject(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showMessage() {
        Toast.makeText(this,"hello",Toast.LENGTH_LONG).show();
    }
}
