package com.example.epoxysimple.model

import android.widget.TextView
import com.example.epoxysimple.R
import com.example.epoxysimple.helpers.KotlinModel

data class ItemPostDataClass(val name: String): KotlinModel(R.layout.item_post) {

    val nameView by bind<TextView>(R.id.testName)
    override fun bind() {

        nameView.text = name
    }
}