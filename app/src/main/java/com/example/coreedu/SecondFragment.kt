

package com.example.coreedu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.hw2.R
import java.util.*


class SecondFragment : Fragment() {
    fun SecondFragment() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myView: View = inflater.inflate(R.layout.fragment2, container, false)
        var spinChoice: Int = 0


        val listOfSubjects = resources.getStringArray(R.array.Subjects)
        val listOfDesc = resources.getStringArray(R.array.Desc)

        val spinner: Spinner = myView.findViewById(R.id.spinner)

       //Help with Spinner Code came from: https://www.geeksforgeeks.org/spinner-in-kotlin/
        if (spinner != null) {
            val adapter = ArrayAdapter(
                requireActivity(), android.R.layout.simple_spinner_item, listOfSubjects
            )
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    spinChoice = position
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }
        }


        val discover: Button = myView.findViewById(R.id.btn)
        val textBox: TextView = myView.findViewById(R.id.finalView)
        val yearBox: TextView = myView.findViewById(R.id.yearFact)

        var finalResult: String = ""

        discover.setOnClickListener(View.OnClickListener {
            textBox.setText("")
            yearBox.setText("")

            finalResult = ""
            //example for political history
            if(spinChoice == 0){
                yearBox.setText("ERA OF SNIPPET: 1860s")
                finalResult += "\nDuring the election of 1860, Broughton's Monthly published four issues " +
                        "featuring engraved portraits of 1860 presidential candidates with astrological charts. " +
                        "It included commentary on their potential success based on a readings of their horoscopes"
            }
            //example for womens history
            else if(spinChoice == 8){
                yearBox.setText("ERA OF SNIPPET: 1970s")
                finalResult += "\nCarol Shaw was the first professional female video game designer and programmer."
                finalResult += " She was best known for developing the vertically scrolling shooter games " +
                        "River Raid, 3-D Tic-Tac-Toe, Scramble (Activision) and Video Checkers." +
                        "Her game 3-D Tic Tac Toe took her only six months to create."
            }
            else{
                var min = 17
                var max = 20
                val cc: Int = Random().nextInt(max - min + 1) + min
                min = 0
                max = 9
                val yy: Int = Random().nextInt(max - min + 1) + min
                yearBox.setText("ERA OF SNIPPET: " + cc + yy + "0s")
                finalResult += "\nLorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                        "when an unknown printer took a galley of type and scrambled it to make a type " +
                        "specimen book. It has survived not only five centuries, but also the leap " +
                        "into electronic typesetting, remaining essentially unchanged."
            }

            textBox.setText(finalResult)
        })




        return myView
    }
}