package com.lskycity.timer;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by liuzhaofeng on 12/21/15.
 */
public class BaseDialogFragment extends DialogFragment {

    public interface DialogFragmentInterface {
        void doDialogPositiveClick(DialogFragment dialog, Bundle bundle);
        void doDialogNegativeClick(DialogFragment dialog, Bundle bundle);
        void doDialogNeutralClick(DialogFragment dialog, Bundle bundle);
    }

    private DialogFragmentInterface mDialogFragmentInterface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getParentFragment() != null) {
            if(getParentFragment() instanceof DialogFragmentInterface) {
                mDialogFragmentInterface = (DialogFragmentInterface) getParentFragment();
            } else {
                throw new ParentNotImplementListenerException("the parent fragment should implements DialogFragmentInterface, " +
                        "the fragment is " + getClass().getName()
                        +", parent fragment is " + getParentFragment().getClass().getName());
            }
        } else {
            if(getActivity() instanceof DialogFragmentInterface) {
                mDialogFragmentInterface = (DialogFragmentInterface) getActivity();
            } else {
                throw new ParentNotImplementListenerException("this activity should implements DialogFragmentInterface, " +
                        "the fragment is " + getClass().getName()
                        +", target activity is " + getActivity().getClass().getName());

            }
         }
    }

    public final void callPositiveClicked(Bundle bundle) {
        mDialogFragmentInterface.doDialogPositiveClick(this, bundle);
    }

    public final void callNegativeClicked(Bundle bundle) {
        mDialogFragmentInterface.doDialogNegativeClick(this, bundle);
    }

    public final void callNeutralClicked(Bundle bundle) {
        mDialogFragmentInterface.doDialogNeutralClick(this, bundle);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        callNegativeClicked(null);
    }

    public void show(FragmentActivity activity, String tag) {
        super.show(activity.getSupportFragmentManager(), tag);
    }

    public void show(Fragment fragment, String tag) {
        super.show(fragment.getChildFragmentManager(), tag);
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        throw new UnsupportedOperationException("you should invoke method show(FragmentActivity, String) or show(Fragment, String) instead");
    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        throw new UnsupportedOperationException("you should invoke method show(FragmentActivity, String) or show(Fragment, String) instead");
    }
}
