package com.itstep.newyorktimesnews.mvp.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.itstep.newyorktimesnews.R;
import com.itstep.newyorktimesnews.adapters.TabsAdapter;
import com.itstep.newyorktimesnews.base.App;
import com.itstep.newyorktimesnews.base.mvp.MvpFragmentView;
import com.itstep.newyorktimesnews.mvp.contracts.DetailsContract;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by virus on 24.05.2018.
 */

public class DetailsFragmentView extends MvpFragmentView<DetailsContract.presenter> implements DetailsContract.view {

    private final static String ARG_URL="_url_arg";
    @BindView(R.id.webview)
    WebView webView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.details_view,container,false);
        App.get(getContext()).injector().inject(this);
        ButterKnife.bind(this,rootView);
        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }


        });
        if(url!=null){
            webView.loadUrl(url);
        }
    }

    public static Fragment getInstance(String url) {
        DetailsFragmentView fragment = new DetailsFragmentView();
        Bundle args = new Bundle();
        args.putString(ARG_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    String url=null;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString(ARG_URL);
        }
    }
}
