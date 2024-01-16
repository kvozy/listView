package com.example.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckedTextView
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var array = arrayListOf<String>()
        var arrayAdapter: ArrayAdapter<String>

        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        val listView = findViewById<ListView>(R.id.listView)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_checked, array)

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->

            val checkedTextView = view as CheckedTextView
            if (checkedTextView.isChecked) {
                array.removeAt(position)
            } else {
                checkedTextView.isChecked = true
            }
            arrayAdapter.notifyDataSetChanged()

        }




            button.setOnClickListener{
            val inputText = editText.text.toString()

            array.add(inputText)
            editText.text.clear()
            arrayAdapter.notifyDataSetChanged()

        }
    }
}