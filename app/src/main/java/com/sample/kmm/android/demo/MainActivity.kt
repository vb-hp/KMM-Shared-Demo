package com.sample.kmm.android.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.sample.kmm.demo.network.RepoInfoRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var viewModel: CQ5ViewModel = CQ5ViewModel(RepoInfoRepository())
    private var adapter: RepoAdapter = RepoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity_main_rv.adapter = adapter

        //trigger here
        viewModel.fetch()

        //observer here
        viewModel.cq5Data.observe(this, Observer { it ->
            adapter.update(it)
        })

    }
}
