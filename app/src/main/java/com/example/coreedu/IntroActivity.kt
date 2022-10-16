package com.example.coreedu

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.example.hw2.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity)
        val simpleFrameLayout: FrameLayout = findViewById(R.id.simpleFrameLayout);
        val tabs: TabLayout = findViewById(R.id.tabs)

        tabs.addTab(tabs.newTab().setText("Discover"));
        tabs.addTab(tabs.newTab().setText("Events"));
        tabs.addTab(tabs.newTab().setText("Progress"));

        var fragment: Fragment? = SecondFragment()

        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        if (fragment != null) {
            ft.replace(R.id.simpleFrameLayout, fragment)
        }
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft.commit()

        tabs.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

                var fragment: Fragment? = null
                when (tab.position) {
                    0 -> fragment = SecondFragment()
                    1 -> fragment = FirstFragment()
                    2 -> fragment = ThirdFragment()
                }
                val fm: FragmentManager = supportFragmentManager
                val ft: FragmentTransaction = fm.beginTransaction()
                if (fragment != null) {
                    ft.replace(R.id.simpleFrameLayout, fragment)
                }
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ft.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


    }
}