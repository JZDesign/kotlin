package com.example.jacobrakidzich.kotlintestingapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private class Student(val name: String, val age: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val student = Student("Brian", 100)
        val student2 = Student(name = "Doug", age = 20)
        val student3 = Student(age = 10, name = "George")

        Log.d("Students", student.name)

//        for (i in 0..100) {
//            if (i %15 == 0 ){
//                Log.i("FizzBuzz", i.toString())
//            } else {
//                if ( i %3 == 0) {
//
//                    Log.i("Fizz", i.toString())
//                }
//                if ( i %5 == 0) {
//                    Log.i("Buzz", i.toString())
//                }
//            }
//        }
    }
}
