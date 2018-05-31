package com.itstep.newyorktimesnews.mvp.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.itstep.newyorktimesnews.R;
import com.itstep.newyorktimesnews.ViewModel.CategoryVM;
import com.itstep.newyorktimesnews.adapters.NewsRvArapter;
import com.itstep.newyorktimesnews.base.App;
import com.itstep.newyorktimesnews.base.mvp.MvpActivityView;
import com.itstep.newyorktimesnews.entities.News;
import com.itstep.newyorktimesnews.events.OpenDetailsEvent;
import com.itstep.newyorktimesnews.events.SelectCategoryEvent;
import com.itstep.newyorktimesnews.mvp.contracts.MainContract;
import com.itstep.newyorktimesnews.utils.Constants;
import com.itstep.newyorktimesnews.utils.DataBus;
import com.itstep.newyorktimesnews.utils.FragmentUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;

public class MainActivityView extends AppCompatActivity {

    FragmentUtils fragmentUtils;
    Disposable dataBusDisposable;

    @BindView(R.id.navigationView)
    NavigationView navigationView;

    @Inject
    CategoryVM categoryVM;

    @Inject
    DataBus dataBus;

    private void initFragment(){
        fragmentUtils = new FragmentUtils(getSupportFragmentManager(),R.id.rootView,"MAIN_ACTIVITY_FRAG");
        Fragment fragment = fragmentUtils.getPreviousInstance();
        if(fragment == null) fragment = new MainFragmentView();
        fragmentUtils.replace(fragment,false);
    }


    private void initNavigationView(){
        navigationView.setNavigationItemSelectedListener(item->{
            categoryVM.setCategory((String) item.getTitle());
            dataBus.sendEvent(new SelectCategoryEvent((String) item.getTitle()));
            return true;
        });
        navigationView.setCheckedItem(R.id.one);
    }

    private void initDataBus(){
        dataBusDisposable = dataBus.getBus()
                .filter(e->e.getName().equals(Constants.EventNames.OPEN_DETAILS))
                .map(e->(OpenDetailsEvent)e)
                .subscribe(e->{
                    fragmentUtils.replace(DetailsFragmentView.getInstance(e.getUrl()), true);
                });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutInflater().inflate(R.layout.activity_main,null));
        ButterKnife.bind(this);
        App.get(this).injector().inject(this);
        initFragment();
        initNavigationView();
        initDataBus();
    }

    @Override
    protected void onDestroy() {
        dataBusDisposable.dispose();
        super.onDestroy();
    }
}
