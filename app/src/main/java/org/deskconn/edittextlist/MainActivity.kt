package org.deskconn.edittextlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    lateinit var listView: ListView
    private lateinit var addButton: Button
    lateinit var showButton: Button
    private var arrayList: ArrayList<String> = ArrayList()
    lateinit var arrayAdapter: ArrayAdapter<String>

    private var hashMap: MutableMap<Any, String> = HashMap()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editTextId)
        listView = findViewById(R.id.listViewId)
        addButton = findViewById(R.id.addButtonId)
        showButton = findViewById(R.id.showButtonId)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)

        addButton.setOnClickListener {
            hashMap["Key"] = editText.text.toString() //Adding edittext value/text in hashmap
            arrayList.add(hashMap.values.toString()) //Adding the hashmap into arraylist and showing only values of hashmap
            editText.setText("")
            println("Hashmap is: $arrayList")
        }
        showButton.setOnClickListener {
            //arrayList = hashMap.map { "(${it.key}, ${it.value})" } as ArrayList<String>
            println("Hashmap is: $arrayList")
            arrayAdapter.notifyDataSetChanged()
            listView.adapter = arrayAdapter
        }
    }
}

