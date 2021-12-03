package com.z.ztab;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

/*
    if (mHomeFragment == null) {
        mHomeFragment = new HomeFragment();
    }

    FragmentManager sfm = getSupportFragmentManager();
    FragmentTransaction ft = sfm.beginTransaction();

    // hide all other fragment
    List<Fragment> fragments = sfm.getFragments();
    for (Fragment fragment : fragments) {
        ft.hide(fragment);
    }

    // if mHomeFragment exists, then show; otherwise, then add
    if (fragments.contains(mHomeFragment)) {
        ft.show(mHomeFragment);
    } else {
        ft.add(R.id.home_tab_fl, mHomeFragment);
    }

    //ft.replace(R.id.home_tab_fl, mHomeFragment);
    ft.commit();
*/
public final class FragmentManagerUtil {

    private final FragmentManager mFragmentManager;
    private final int mContainerViewId;

    public FragmentManagerUtil(@NonNull FragmentManager fragmentManager, @IdRes int containerViewId) {
        mFragmentManager = fragmentManager;
        mContainerViewId = containerViewId;
    }

    public void add(@NonNull Fragment fragment) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.add(mContainerViewId, fragment);
        ft.commit();
    }

    public void switchFragment(@NonNull Fragment fragment) {

        FragmentTransaction ft = mFragmentManager.beginTransaction();

        // hide all other fragment
        List<Fragment> childFragments = mFragmentManager.getFragments();
        for (Fragment childFragment : childFragments) {
            ft.hide(childFragment);
        }

        // if mHomeFragment exists, then show; otherwise, then add
        if (childFragments.contains(fragment)) {
            ft.show(fragment);
        } else {
            ft.add(mContainerViewId, fragment);
        }

        //ft.replace(R.id.home_tab_fl, mHomeFragment);
        ft.commit();
    }

}
