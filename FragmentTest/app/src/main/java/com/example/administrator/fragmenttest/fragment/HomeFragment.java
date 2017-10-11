package com.example.administrator.fragmenttest.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.fragmenttest.MainActivity;
import com.example.administrator.fragmenttest.R;

import java.util.Random;



public class HomeFragment extends Fragment {
    private Button but_back;
    private TextView tv_first;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);
        but_back = (Button) view.findViewById(R.id.but_back);
        tv_first = (TextView) view.findViewById(R.id.tv_first);

        final MainActivity mainActivity = (MainActivity) getActivity();
        Bundle arguments = getArguments();
        String count = arguments.getString("count");

       // tv_first.setText(count);










        but_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int i = random.nextInt(100);

                //mainActivity.tvSet(i+"");

               /* if (onbuttonChecklistener != null) {
                    onbuttonChecklistener.buttonCheck(i);

                }*/

            }
        });


        return view;


    }

    OnbuttonChecklistener onbuttonChecklistener;

    public void setOnbuttonChecklistener(OnbuttonChecklistener onbuttonChecklistener) {
        this.onbuttonChecklistener = onbuttonChecklistener;
    }

    public interface OnbuttonChecklistener {
        void buttonCheck(int i);
    }



    public void setTest(String info){
        tv_first.setText(info);
    }


}
