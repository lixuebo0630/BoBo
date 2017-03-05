package com.lixuebo.bobo.factory;

import android.support.v4.app.Fragment;

import com.lixuebo.bobo.vm.fragment.AppFragment;
import com.lixuebo.bobo.vm.fragment.HomeFragment;

/**
 * Created by lixuebo on 17/3/5.
 */

public class FragmentFactory {

    private static Fragment fragment = null;

    public static Fragment getFragment(int position) {
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;

            case 1:
                fragment = new AppFragment();
                break;
            default:
                break;
        }


        return fragment;
    }
}
