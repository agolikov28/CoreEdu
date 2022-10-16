package com.example.coreedu

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.hw2.R
import java.util.*


class ThirdFragment : Fragment() {
    fun ThirdFragment() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myView: View = inflater.inflate(R.layout.fragment3, container, false)
        val addBtn: Button = myView.findViewById(R.id.add)

        var bar1 : ProgressBar = myView.findViewById(R.id.histBar1)
        var bar2 : ProgressBar = myView.findViewById(R.id.histBar2)
        var bar3 : ProgressBar = myView.findViewById(R.id.histBar3)

        bar1.setProgress(90, true)
        bar2.setProgress(40, true)
        bar3.setProgress(22, true)

        bar1.progressTintList =
            ColorStateList.valueOf(this.resources.getColor(R.color.secondBlue))
        bar2.progressTintList =
            ColorStateList.valueOf(this.resources.getColor(R.color.secondBlue))
        bar3.progressTintList =
            ColorStateList.valueOf(this.resources.getColor(R.color.secondBlue))

        addBtn.setOnClickListener(View.OnClickListener {

        })

        return myView
    }
}