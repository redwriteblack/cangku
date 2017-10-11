package com.example.administrator.fragmenttest.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.fragmenttest.MainActivity;
import com.example.administrator.fragmenttest.R;

/**
 * Created by Administrator on 2017/9/20.
 */

public class AppFragment extends Fragment {
    private Button but_skap;
    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_app, null);
        mainActivity = (MainActivity) getActivity();


        but_skap = (Button) view.findViewById(R.id.but_skap);
        but_skap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.setTvtest("首页改");
            }
        });



        return view;

    }
}
