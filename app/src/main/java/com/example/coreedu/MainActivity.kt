
package com.example.coreedu

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.hw2.R


class MainActivity : AppCompatActivity() {


    private lateinit var fragment1: IntroFragment
    private lateinit var fragment2: IntroFragment
    private lateinit var fragment3: IntroFragment
    private lateinit var indicator1: TextView
    private lateinit var indicator2: TextView
    private lateinit var indicator3: TextView
    private lateinit var backButton: Button
    private lateinit var nextButton: Button
    private lateinit var adapter: MyPagerAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var ourView: RelativeLayout


    lateinit var preference: SharedPreferences
    val prefIntro = "Intro"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ourView = findViewById(R.id.intro_layout)

        val introIntent = Intent(this, IntroActivity::class.java)
        preference = getSharedPreferences("IntroSlider", Context.MODE_PRIVATE)


        fragment1 = IntroFragment()
        fragment2 = IntroFragment()
        fragment3 = IntroFragment()

        indicator1 = findViewById(R.id.indicator1)
        indicator2 = findViewById(R.id.indicator2)
        indicator3 = findViewById(R.id.indicator3)

        backButton = findViewById(R.id.backbtn)
        nextButton = findViewById(R.id.nextbtn)

        nextButton.setBackgroundColor(applicationContext.resources.getColor(R.color.thirdBlue))
        backButton.setBackgroundColor(applicationContext.resources.getColor(R.color.thirdBlue))


        viewPager = findViewById(R.id.view_pager)

        if (!preference.getBoolean(prefIntro, true)) {
            startActivity(introIntent)
        }
        fragment1.setTitle("Welcome to CoreEdu!")
        fragment2.setTitle("LEARN:\n")
        fragment3.setTitle("DISCOVER:\n")

        fragment1.setDesc("")
        fragment2.setDesc("Explore a new history subject daily,\n and educate yourself to reach new heights")
        fragment3.setDesc("Attend and host educational events\nand workshops in your area.\nHistory related, or not!")


        adapter = MyPagerAdapter(supportFragmentManager)
        adapter.list.add(fragment1)
        adapter.list.add(fragment2)
        adapter.list.add(fragment3)

        viewPager.adapter = adapter
        nextButton.setOnClickListener {
            viewPager.currentItem++
        }

        backButton.setOnClickListener {
            viewPager.currentItem--
//            startActivity(homePageIntent)
//            val editor = preference.edit()
//            editor.putBoolean(prefIntro, false)
//            editor.apply()
        }

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (position == adapter.list.size - 1) {
                    //lastPage
                    nextButton.text = "GO!"
                    nextButton.setOnClickListener {
                        startActivity(introIntent)
                        val editor = preference.edit()
                        editor.putBoolean(prefIntro, false)
                        editor.apply()
                    }
                } else {
                    //has next

                    nextButton.text = "NEXT"
                    nextButton.setOnClickListener {
                        viewPager.currentItem++
                    }
                }

                when (viewPager.currentItem) {
                    0 -> {
                        ourView.setBackgroundColor(applicationContext.resources.getColor(R.color.thirdBlue))
                        nextButton.setBackgroundColor(applicationContext.resources.getColor(R.color.thirdBlue))
                        backButton.setBackgroundColor(applicationContext.resources.getColor(R.color.thirdBlue))
                        indicator1.setTextColor(Color.WHITE)
                        indicator2.setTextColor(Color.GRAY)
                        indicator3.setTextColor(Color.GRAY)
                    }
                    1 -> {
                        ourView.setBackgroundColor(applicationContext.resources.getColor(R.color.secondBlue))
                        nextButton.setBackgroundColor(applicationContext.resources.getColor(R.color.secondBlue))
                        backButton.setBackgroundColor(applicationContext.resources.getColor(R.color.secondBlue))
                        indicator1.setTextColor(Color.GRAY)
                        indicator2.setTextColor(Color.WHITE)
                        indicator3.setTextColor(Color.GRAY)
                    }
                    2 -> {
                        ourView.setBackgroundColor(applicationContext.resources.getColor(R.color.thirdBlue))
                        nextButton.setBackgroundColor(applicationContext.resources.getColor(R.color.thirdBlue))
                        backButton.setBackgroundColor(applicationContext.resources.getColor(R.color.thirdBlue))
                        indicator1.setTextColor(Color.GRAY)
                        indicator2.setTextColor(Color.GRAY)
                        indicator3.setTextColor(Color.WHITE)
                    }
                }

            }

        })

    }


    class MyPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        val list: MutableList<Fragment> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return list[position]
        }

        override fun getCount(): Int {
            return list.size
        }

    }

}