package com.example.mybookmark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.mybookmark.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewPager.setAdapter(new ViewPageAdapter(this));//뷰페이저 연결

        TabLayoutMediator.TabConfigurationStrategy strategy = null;
        strategy = new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0){
                    tab.setText("월요일");

                }else if (position == 1){
                    tab.setText("화요일");

                }else if (position == 2) {
                    tab.setText("환경설정");

                }
            }
        };
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, strategy).attach();
    }
}