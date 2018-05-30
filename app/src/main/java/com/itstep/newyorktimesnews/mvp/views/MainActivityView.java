package com.itstep.newyorktimesnews.mvp.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.itstep.newyorktimesnews.R;
import com.itstep.newyorktimesnews.adapters.NewsRvArapter;
import com.itstep.newyorktimesnews.base.App;
import com.itstep.newyorktimesnews.base.mvp.MvpActivityView;
import com.itstep.newyorktimesnews.entities.News;
import com.itstep.newyorktimesnews.events.OpenDetailsEvent;
import com.itstep.newyorktimesnews.mvp.contracts.MainContract;
import com.itstep.newyorktimesnews.utils.DataBus;
import com.itstep.newyorktimesnews.utils.FragmentUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivityView extends AppCompatActivity {

    FragmentUtils fragmentUtils;

    @Inject
    DataBus dataBus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutInflater().inflate(R.layout.activity_main,null));
        fragmentUtils = new FragmentUtils(getSupportFragmentManager(),R.id.rootView);
        fragmentUtils.replace(new MainFragmentView(),false);
        App.get(this).injector().inject(this);
        dataBus.getBus()
                .filter(e->e.getName().equals("open_details"))
                .map(e->(OpenDetailsEvent)e)
                .subscribe(e->{
                    fragmentUtils.replace(DetailsFragmentView.getInstance(e.getUrl()), true);
                });
    }




}
