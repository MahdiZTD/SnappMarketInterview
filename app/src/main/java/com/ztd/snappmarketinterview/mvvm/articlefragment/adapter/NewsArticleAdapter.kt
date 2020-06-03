package com.ztd.snappmarketinterview.mvvm.articlefragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ztd.snappmarketinterview.databinding.ItemNewsArticleBinding
import com.ztd.snappmarketinterview.infrastructure.data.model.db.ArticleEntity
import com.ztd.snappmarketinterview.mvvm.base.BaseViewHolder

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */
class NewsArticleAdapter(private val articles: MutableList<ArticleEntity>) :
    RecyclerView.Adapter<NewsArticleAdapter.ArticleViewHolder>() {

    var clickListener: NewsArticleAdapter.OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
        ArticleViewHolder(
            ItemNewsArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) =
        holder.onBind(position)

    fun addItems(articles: MutableList<ArticleEntity>) {
        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.articles.clear()
    }

    inner class ArticleViewHolder(val mBinding: ItemNewsArticleBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            mBinding.vm = NewsArticleItemViewModel(articles[position], clickListener)
            mBinding.executePendingBindings()
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(articleUrl: String?)
    }


}