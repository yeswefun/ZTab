package com.z.ztab;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.z.ztab.fragment.FindFragment;
import com.z.ztab.fragment.HomeFragment;
import com.z.ztab.fragment.MsgsFragment;
import com.z.ztab.fragment.NewsFragment;

/*
Tab bar
     1. ViewPager + Fragment
        页面缓存问题, viewPager会不断创建与销毁页面(set...)

     2. ViewGroup + Fragment
        我们使用这种

     3. TabHostFragment
        deprecated

BackStackRecord extends FragmentTransactio implements ... {}

FragmentTransactio#add
     ft.add(int, Fragment);   // set basic params

BackStackRecord#commit
     ft.commit()  // core logic
     void moveToState(Fragment f, int newState, int transit,
                     int transitionStyle, boolean keepActive)
         f == HomeFragment / FindFragment / ...
         case Fragment.INITIALIZING:
             f.performAttach();
             mHost.onAttachFragment(f);
             f.performCreate(f.mSavedFragmentState);
         Fragment.CREATED
             ensureInflatedFragmentView(f);
                 f.performCreateView(f.performGetLayoutInflater(f.mSavedFragmentState), null, f.mSavedFragmentState);
                     mView = onCreateView(inflater, container, savedInstanceState);
                         mView == R.id.home_tab_fl

FragmentTransactio#replace
    ft.replace() // remove the top and put current on the top of stack
        added.remove(old);
        added.add(f);
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RadioButton mHomeRb;
    private RadioButton mFindRb;
    private RadioButton mNewsRb;
    private RadioButton mMsgsRb;

    private HomeFragment mHomeFragment;
    private FindFragment mFindFragment;
    private NewsFragment mNewsFragment;
    private MsgsFragment mMsgsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mHomeRb = findViewById(R.id.home_rb);
        mFindRb = findViewById(R.id.find_rb);
        mNewsRb = findViewById(R.id.news_rb);
        mMsgsRb = findViewById(R.id.msgs_rb);
        mHomeRb.setChecked(true);

        homeTabClick(null);
    }

    public void homeTabClick(View view) {
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        FragmentManager sfm = getSupportFragmentManager();
        FragmentTransaction ft = sfm.beginTransaction();
        ft.replace(R.id.home_tab_fl, mHomeFragment);
        ft.commit();
    }

    public void findTabClick(View view) {
        if (mFindFragment == null) {
            mFindFragment = new FindFragment();
        }
        FragmentManager sfm = getSupportFragmentManager();
        FragmentTransaction ft = sfm.beginTransaction();
        ft.replace(R.id.home_tab_fl, mFindFragment);
        ft.commit();
    }

    public void newsTabClick(View view) {
        if (mNewsFragment == null) {
            mNewsFragment = new NewsFragment();
        }
        FragmentManager sfm = getSupportFragmentManager();
        FragmentTransaction ft = sfm.beginTransaction();
        ft.replace(R.id.home_tab_fl, mNewsFragment);
        ft.commit();
    }

    public void msgsTagClick(View view) {
        if (mMsgsFragment == null) {
            mMsgsFragment = new MsgsFragment();
        }
        FragmentManager sfm = getSupportFragmentManager();
        FragmentTransaction ft = sfm.beginTransaction();
        ft.replace(R.id.home_tab_fl, mMsgsFragment);
        ft.commit();
    }
}