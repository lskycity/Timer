package com.lskycity.timer.ui;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.lskycity.support.utils.SharedPreUtils;
import com.lskycity.timer.BaseDialogFragment;
import com.lskycity.timer.Constant;
import com.lskycity.timer.Millis;
import com.lskycity.timer.PickTimeDialogFragment;
import com.lskycity.timer.R;

/**
 * Created by zhaofliu on 7/25/17.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements BaseDialogFragment.DialogFragmentInterface {

    Preference startTime;
    Preference tipTime;
    Preference waringTime;
    Preference normalTime;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
        getPreferenceManager().setSharedPreferencesName(SharedPreUtils.SHARED_PREFERENCE_NAME);

        startTime = getPreferenceScreen().findPreference("key_start_time");
        normalTime = getPreferenceScreen().findPreference("key_normal_time");
        tipTime = getPreferenceScreen().findPreference("key_tip_time");
        waringTime = getPreferenceScreen().findPreference("key_waring_time");

        startTime.setSummary(new Millis(SharedPreUtils.getLong(getContext(), Constant.KEY_START_TIME)).toString());
        tipTime.setSummary(new Millis(SharedPreUtils.getLong(getContext(), Constant.KEY_TIP_TIME)).toString());
        waringTime.setSummary(new Millis(SharedPreUtils.getLong(getContext(), Constant.KEY_WARING_TIME)).toString());
        normalTime.setSummary(new Millis(SharedPreUtils.getLong(getContext(), Constant.KEY_NORMAL_TIME)).toString());

//        version.setSummary(AppUtils.getVersionName(getActivity()));
//
//        int versionCode = SharedPreUtils.getInt(getActivity(), SharedPreUtils.KEY_LAST_DATE_CHECK_VERSION_CODE);
//        if(versionCode > AppUtils.getVersionCode(getActivity())) {
//            String versionName = SharedPreUtils.getString(getActivity(), SharedPreUtils.KEY_LAST_DATE_CHECK_VERSION_NAME);
//            version.setSummary(getString(R.string.current_version_and_have_new_version, AppUtils.getVersionName(getActivity()), versionName));
//
//        }

    }

    @Override
    public boolean onPreferenceTreeClick(Preference preference) {
        if(preference.getKey().equals("key_start_time")) {
            long time = SharedPreUtils.getLong(getContext(), Constant.KEY_START_TIME);
            PickTimeDialogFragment.newInstance(time).show(this, "key_start_time");
        } else if(preference.getKey().equals("key_tip_time")) {
            long time = SharedPreUtils.getLong(getContext(), Constant.KEY_TIP_TIME);
            PickTimeDialogFragment.newInstance(time).show(this, "key_tip_time");
        } else if(preference.getKey().equals("key_waring_time")) {
            long time = SharedPreUtils.getLong(getContext(), Constant.KEY_WARING_TIME);
            PickTimeDialogFragment.newInstance(time).show(this, "key_waring_time");
        } else if(preference.getKey().equals("key_normal_time")) {
            long time = SharedPreUtils.getLong(getContext(), Constant.KEY_NORMAL_TIME);
            PickTimeDialogFragment.newInstance(time).show(this, "key_normal_time");
        }
        return true;
    }


    @Override
    public void doDialogPositiveClick(DialogFragment dialog, Bundle bundle) {
        if(dialog.getTag().equals("key_start_time")) {
            SharedPreUtils.putLong(getContext(), Constant.KEY_START_TIME, bundle.getLong(Constant.KEY_START_TIME));
            startTime.setSummary(new Millis(SharedPreUtils.getLong(getContext(), Constant.KEY_START_TIME)).toString());
        } else if(dialog.getTag().equals("key_tip_time")) {
            SharedPreUtils.putLong(getContext(), Constant.KEY_TIP_TIME, bundle.getLong(Constant.KEY_TIP_TIME));
            tipTime.setSummary(new Millis(SharedPreUtils.getLong(getContext(), Constant.KEY_TIP_TIME)).toString());
        } else if(dialog.getTag().equals("key_waring_time")) {
            SharedPreUtils.putLong(getContext(), Constant.KEY_WARING_TIME, bundle.getLong(Constant.KEY_WARING_TIME));
            waringTime.setSummary(new Millis(SharedPreUtils.getLong(getContext(), Constant.KEY_WARING_TIME)).toString());
        } else if(dialog.getTag().equals("key_normal_time")) {
            SharedPreUtils.putLong(getContext(), Constant.KEY_NORMAL_TIME, bundle.getLong(Constant.KEY_NORMAL_TIME));
            normalTime.setSummary(new Millis(SharedPreUtils.getLong(getContext(), Constant.KEY_NORMAL_TIME)).toString());
        }

    }

    @Override
    public void doDialogNegativeClick(DialogFragment dialog, Bundle bundle) {

    }

    @Override
    public void doDialogNeutralClick(DialogFragment dialog, Bundle bundle) {

    }
}
