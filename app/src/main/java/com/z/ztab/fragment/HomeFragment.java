package com.z.ztab.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.z.ztab.R;

public class HomeFragment extends BaseFragment {

    private static final String TAG = "HomeFragment";
    private TextView tvText;

    @Override
    protected void initView() {
        tvText = getActivity().findViewById(R.id.test_tv);
        Log.e(TAG, "initView: tvText: " + tvText);
        tvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v;
                tv.setText(tv.getText() + "0");
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

}
