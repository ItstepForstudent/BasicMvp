package com.itstep.newyorktimesnews.mvp.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itstep.newyorktimesnews.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabViewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String CATEGORY_ARG = "param1";
    private static final String TYPE_ARG = "param2";

    // TODO: Rename and change types of parameters
    private String categoryNews;
    private String typeNews;


    public TabViewFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TabViewFragment newInstance(String category, String type) {
        TabViewFragment fragment = new TabViewFragment();
        Bundle args = new Bundle();
        args.putString(CATEGORY_ARG, category);
        args.putString(TYPE_ARG, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoryNews = getArguments().getString(CATEGORY_ARG);
            typeNews = getArguments().getString(TYPE_ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

}
