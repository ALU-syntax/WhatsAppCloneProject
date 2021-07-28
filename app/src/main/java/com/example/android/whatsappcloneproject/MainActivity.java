package com.example.android.whatsappcloneproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.whatsappcloneproject.databinding.ActivityMainBinding;
import com.example.android.whatsappcloneproject.menu.CallsFragment;
import com.example.android.whatsappcloneproject.menu.ChatsFragment;
import com.example.android.whatsappcloneproject.menu.StatusFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setUpWithViewPager(binding.viewPager);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        setSupportActionBar(binding.toolbar);
    }

    private void setUpWithViewPager(ViewPager viewPager){
        MainActivity.SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new ChatsFragment(), "Chats");
        adapter.addFragment(new StatusFragment(), "Status");
        adapter.addFragment(new CallsFragment(), "Calls ");

        //kita membutuhkan 3 fragment
        viewPager.setAdapter(adapter);

    }

    //Pager Adapter kita taruh di inner class dalam main activity
    private static class SectionPagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handler action bar item, logicnya ditaro disini
        // Action bar akan selamanya menangani on click disini
        // tanpa harus membuat onClickListener, selama fungsi ini
        // ditetapkan di android manifest sebagai parent activity

        int id = item.getItemId();

        switch (id){
            case R.id.menu_search :
                Toast.makeText(MainActivity.this, "Action Search", Toast.LENGTH_SHORT).show();break;
            case R.id.menu_more:
                Toast.makeText(MainActivity.this, "Menu Search", Toast.LENGTH_SHORT).show();break;
        }
        return super.onOptionsItemSelected(item);
    }
}