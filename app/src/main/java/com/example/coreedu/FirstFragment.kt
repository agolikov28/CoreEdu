package com.example.coreedu

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.hw2.R
import java.util.*


class FirstFragment : Fragment() {
    fun FirstFragment() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
// Inflate the layout for this fragment
        val myView2: View = inflater.inflate(R.layout.fragment1, container, false)

        val enter: Button = myView2.findViewById(R.id.btn2)
        val mZip: EditText= myView2.findViewById(R.id.zipCode)

        enter.setOnClickListener(View.OnClickListener {
            val textBox: TextView = myView2.findViewById(R.id.listEvents)
            val linkTextView: TextView = myView2.findViewById(R.id.event1)

            textBox.setText("Events and Opportunities near " + mZip.text.toString())
            textBox.visibility = View.VISIBLE

            linkTextView.setText("> Learn about Indigenous land in your area: Visit native-land.ca to find out more.\n\n> Volunteer to teach Python at your local library: Visit technifusion.org to sign up today!"
                    +"\n\n> Attend the Historical Society's seminar and info session on the Colonized land in your area, and learn how you can give back to the communities in need"
                    +"\n\n> Join the Historic Preservation Group as they take on advocacy work: \nVisit preservationdirectory.com and start advocating!")
//            linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
//            linkTextView.setLinkTextColor(Color.BLUE)
            linkTextView.visibility = View.VISIBLE

        })


        return myView2
    }
}