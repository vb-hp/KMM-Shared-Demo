package com.sample.kmm.demo.network

import com.sample.kmm.demo.ApplicationDispatcher
import com.sample.kmm.demo.model.RepoInfo
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json

class RepoInfoRepository {

    private val httpClient = HttpClient()

    fun fetchAsync(username: String, callback: (articles: List<RepoInfo>) -> Unit) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val url = "https://api.github.com/users/${username}/repos"

                val json = httpClient.get<String>(url)

                val response = Json.nonstrict.parse(RepoInfo.serializer().list, json)


                callback(response)
            } catch (ex: Exception) {
                println("FAFA , error fetching repos:" + ex.message)
                callback(emptyList())
            }
        }
    }
}