package com.example.epoxysimple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.airbnb.epoxy.EpoxyVisibilityTracker
import com.example.epoxysimple.model.ItemPostDataClass
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        initViewModel()
    }

    private fun initViewModel() {

        val epoxyVisibilityTracker = EpoxyVisibilityTracker()
        epoxyVisibilityTracker.attach(recyclerView)

        viewModel.getPost().observe(this, Observer {
            recyclerView.withModels {

                it.forEachIndexed { index, post ->
                    ItemPostDataClass(post.title)
                        .id("data class $index")
                        .addTo(this)
                }
            }

        })
    }
}
