package com.sample.kmm.android.demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.kmm.demo.model.RepoInfo
import com.sample.kmm.demo.network.RepoInfoRepository

class CQ5ViewModel(private val repoInfoRepository: RepoInfoRepository) : ViewModel() {

    val cq5Data = MutableLiveData<List<RepoInfo>>()

    fun fetch() {
        val userName = "vb-hp"

        repoInfoRepository.fetchAsync(userName) { repos ->
            cq5Data.postValue(repos)
        }
    }
}