package com.lamps.lamps.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.lamps.lamps.R;
import com.lamps.lamps.activity.MainActivity;
import com.lamps.lamps.util.CommandUtils;

/**
 * Created by stew on 16/9/3.
 * mail: stewforani@gmail.com
 */
public class LightFragment extends Fragment {
    private static final String TAG = "LightFragment";
    private View rootView;
    private String order = CommandUtils.LIGHT_1;
    private String speed = CommandUtils.SPEED_1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_catch_light, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {

        SeekBar seekBar = (SeekBar) rootView.findViewById(R.id.seekBar_catch_light);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                int progress = seekBar.getProgress();

                if (progress < 50) {
                    seekBar.setProgress(0);
                    order = CommandUtils.LIGHT_1;
                } else if (progress < 100) {
                    seekBar.setProgress(100);
                    order = CommandUtils.LIGHT_2;
                }
                ((MainActivity) getActivity()).sendOrder(order);
            }
        });


        SeekBar seekBarSpeed = (SeekBar) rootView.findViewById(R.id.seekBar_speed);
        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                int progress = seekBar.getProgress();
                if (progress < 25) {
                    seekBar.setProgress(0);
                    speed = CommandUtils.SPEED_1;
                } else if (progress < 75) {
                    seekBar.setProgress(50);
                    speed = CommandUtils.SPEED_2;
                } else {
                    seekBar.setProgress(100);
                    speed = CommandUtils.SPEED_3;
                }
                ((MainActivity) getActivity()).sendSpeed(speed);
            }
        });

    }

    public String getOrder() {
        return order;
    }


    public String getSpeed() {
        return speed;
    }
}
