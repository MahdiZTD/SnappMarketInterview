package com.ztd.snappmarketinterview.mvvm

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ztd.snappmarketinterview.infrastructure.data.model.db.ArticleEntity
import com.ztd.snappmarketinterview.infrastructure.data.model.db.SourceEntity
import com.ztd.snappmarketinterview.mvvm.articlefragment.adapter.NewsArticleAdapter
import com.ztd.snappmarketinterview.mvvm.sourcesfragment.adapter.NewsSourceAdapter

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */
object DataBindingUtils {

    @JvmStatic
    @BindingAdapter("sourceAdapter")
    fun addSourceAdapter(recyclerView: RecyclerView, sources: MutableList<SourceEntity>?) {
        if (sources!=null) {
            val adapter = recyclerView.adapter as NewsSourceAdapter?
            adapter?.clearItems()
            adapter?.addItems(sources)
        }
    }

    @JvmStatic
    @BindingAdapter("articleAdapter")
    fun addArticleAdapter(recyclerView: RecyclerView, articles: MutableList<ArticleEntity>?) {
        if (articles!=null) {
            val adapter = recyclerView.adapter as NewsArticleAdapter?
            adapter?.clearItems()
            adapter?.addItems(articles)
        }
    }
}