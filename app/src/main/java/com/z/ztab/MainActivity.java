package com.z.ztab;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

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

保存状态的思路:
    如果容器中没有就添加, 否则就显示当前，隐藏所有已经添加的
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

    private FragmentManagerUtil mFragmentManagerUtil;

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

        mFragmentManagerUtil = new FragmentManagerUtil(getSupportFragmentManager(), R.id.home_tab_fl);
        homeTabClick(null);
    }

    public void homeTabClick(View view) {
        Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        mFragmentManagerUtil.switchFragment(mHomeFragment);
    }

    public void findTabClick(View v) {
        Toast.makeText(this, "find", Toast.LENGTH_SHORT).show();
        if (mFindFragment == null) {
            mFindFragment = new FindFragment();
        }
        mFragmentManagerUtil.switchFragment(mFindFragment);
    }

    public void msgsTagClick(View v) {
        Toast.makeText(this, "msgs", Toast.LENGTH_SHORT).show();
        if (mMsgsFragment == null) {
            mMsgsFragment = new MsgsFragment();
        }
        mFragmentManagerUtil.switchFragment(mMsgsFragment);
    }

    public void newsTabClick(View v) {
        Toast.makeText(this, "news", Toast.LENGTH_SHORT).show();
        if (mNewsFragment == null) {
            mNewsFragment = new NewsFragment();
        }
        mFragmentManagerUtil.switchFragment(mNewsFragment);
    }
}