package test.demo.dahua.com.testfragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import test.demo.dahua.com.testfragment.MainActivity;
import test.demo.dahua.com.testfragment.R;

/**
 * Created by dragon on 2017/9/19.
 */

public class MeFragment extends Fragment {
    private final String TAG = "HomeFragment";
    private View view;
    private TextView tv_str;
    private Button btn_01;
    private MainActivity mainActivity;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // Bundle bundle = getArguments();
       // String str = bundle.getString("str", "");

        mainActivity = (MainActivity) getActivity();

        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_me, null);
       // btn_01 = (Button) view.findViewById(R.id.btn_01);
        btn_01 = (Button) view.findViewById(R.id.btn_01);
        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int i = random.nextInt();
                mainActivity.setFragmentText(i+"");
            }
        });

        return view;


    }
}
