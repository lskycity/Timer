package com.lskycity.timer;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhaofliu on 7/25/17.
 */

public class PickTimeDialogFragment extends BaseDialogFragment {

    @BindView(R.id.minusInput)
    EditText minusInput;

    @BindView(R.id.secondInput)
    EditText secondInput;

    public static PickTimeDialogFragment newInstance(long time) {
        PickTimeDialogFragment f = new PickTimeDialogFragment();
        Bundle args = new Bundle();
        args.putLong("time", time);
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pick_dialog, container, false);
//        ButterKnife.bind(v);
        long time = getArguments().getLong("time");
        minusInput = (EditText) v.findViewById(R.id.minusInput);
        secondInput = (EditText) v.findViewById(R.id.secondInput);
        minusInput.setText(String.valueOf(time/1000/60 % 60));
        secondInput.setText(String.valueOf(time/1000 % 60));

        v.findViewById(android.R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long minus;
                long second;

                try {
                    minus = Integer.parseInt(minusInput.getText().toString());
                } catch (NumberFormatException e) {
                    minus = 0;
                }

                try {
                    second = Integer.parseInt(secondInput.getText().toString());
                } catch (NumberFormatException e) {
                    second = 0;
                }


                Bundle bundle = new Bundle();
                bundle.putLong(getTag(), minus*60*1000 + second*1000);
                callPositiveClicked(bundle);
                dismissAllowingStateLoss();
            }
        });

        v.findViewById(android.R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNegativeClicked(null);
                dismissAllowingStateLoss();
            }
        });

        return v;
    }

}
