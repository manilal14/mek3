 package com.example.mani.mek3;

 import android.graphics.drawable.ColorDrawable;
 import android.os.Bundle;
 import android.support.design.widget.TabLayout;
 import android.support.v4.app.Fragment;
 import android.support.v4.view.ViewPager;
 import android.support.v7.app.AppCompatActivity;
 import android.text.Html;

 import java.util.ArrayList;
 import java.util.List;

 public class BookingMainPage extends AppCompatActivity {

    List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_main_page);


        getSupportActionBar().setTitle("Bookings");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                .getColor(R.color.white)));
        getSupportActionBar().setElevation(0);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + "Bookings" + "</font>"));






        mFragmentList = new ArrayList<>();
        mFragmentList.add(new FragmentBookingUpcoming());
        mFragmentList.add(new FragmentBookingHistory());

        ViewPager viewPager = findViewById(R.id.viewpager_homepage);

        BookingFragmentPagerAdapter adapter = new BookingFragmentPagerAdapter(
                getSupportFragmentManager(),mFragmentList);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }


 }
