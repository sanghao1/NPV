package com.example.alovan;

import android.Manifest;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.Home.LocalService;
import com.example.myapplication.Home.myJobScheduler;
import com.example.myapplication.NPVSharedPreference.LocalDataManager;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import java.util.Set;

public class HomeActivity extends AppCompatActivity {


    private ActionBar toolbar;

    private static final String KEY_USERNAME = "Key_User";
    private static final int JOB_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        Set<String> getUserName = LocalDataManager.getUserName();
        String[] User_Name = getUserName.toArray(new String[1]);
        String UserName = String.valueOf(User_Name[1]);

        StartJobScheduler();;

}

    private void StartJobScheduler() {
        ComponentName componentName = new ComponentName(this, myJobScheduler.class);
        JobInfo jobInfo = new JobInfo.Builder(JOB_ID,componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setPersisted(true)
                //.setPeriodic(30000)
                .build();
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(jobInfo);
    }
    private void StartServiceNotification(){
        Intent intent = new Intent(this, LocalService.class);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            selectedFragment = new FuntionB();
                            break;
                        case R.id.navigation_dashboard:
                            selectedFragment = new Funtion1Framgremt();
                            break;
                        case R.id.navigation_notifications:
                            selectedFragment = new notifiCationApp();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
    };
}
