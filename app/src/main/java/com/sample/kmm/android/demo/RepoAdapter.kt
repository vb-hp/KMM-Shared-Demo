package com.sample.kmm.android.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.kmm.demo.model.RepoInfo
import kotlinx.android.synthetic.main.article_item_layout.view.*

class RepoAdapter(
    private var articlesList: MutableList<RepoInfo> = mutableListOf()
) : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    override fun getItemCount() = articlesList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.article_item_layout, parent, false)
        return RepoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(articlesList[position])
    }

    class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(repoInfo: RepoInfo) = with(itemView) {
            repo_details.text = repoInfo.name + "\n" + repoInfo.url
        }
    }

    fun update(articles: List<RepoInfo>) {
        articlesList.clear()
        articlesList.addAll(articles)
        notifyDataSetChanged()
    }
}

