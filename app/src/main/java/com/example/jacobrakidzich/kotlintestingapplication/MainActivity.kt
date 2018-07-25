package com.example.jacobrakidzich.kotlintestingapplication

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity : AppCompatActivity() {

    private class Student(val name: String, val age: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // get list View by ID from the XML
        val listView = findViewById<ListView>(R.id.main_listView)
//        val redColor = Color.parseColor("#ff0000")
//        listView.setBackgroundColor(redColor)

        // to include data in the list view you need an adapter
        listView.adapter = MyCustomAdapter()

    }


    private class MyCustomAdapter(): BaseAdapter() {

        //private val mContext: Context
        private val names = arrayListOf<String>(
                "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barack Obama"
        )

//        init {
//            mContext = context
//        }

        // responsible for rendering each row
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val rowMain : View
            if (p1 == null) {
                val layoutInflater = LayoutInflater.from(p2!!.context)
                rowMain = layoutInflater.inflate(R.layout.row_main, p2,false)

                Log.v("getView","calling findViewByID is expensive")
                val nameTextView = rowMain.name_textView
                val positionTextView = rowMain.positiontextView

                val viewHolder = ViewHolder(nameTextView,positionTextView)
                rowMain.tag = viewHolder
            } else {
                rowMain = p1
            }
            val viewHolder = rowMain.tag as ViewHolder
            viewHolder.nameTextView.text = names.get(p0)
            viewHolder.positionTextView.text = "Row Number: $p0"
            return rowMain
        }

        override fun getItem(p0: Int): Any {
            return "TEST STRING"

        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return names.size

        }

        private class ViewHolder(val nameTextView:TextView, val positionTextView:TextView){

        }

    }
}
