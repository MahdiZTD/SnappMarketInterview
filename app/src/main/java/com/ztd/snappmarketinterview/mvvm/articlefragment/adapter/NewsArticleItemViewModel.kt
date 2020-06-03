package com.ztd.snappmarketinterview.mvvm.articlefragment.adapter

import androidx.databinding.ObservableField
import com.ztd.snappmarketinterview.infrastructure.data.model.db.ArticleEntity

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */
class NewsArticleItemViewModel(
    private val article: ArticleEntity,
    private val clickListener: NewsArticleAdapter.OnItemClickListener?
) {

    val author = ObservableField<String>(article.author)
    val title = ObservableField<String>(article.title)
    val description = ObservableField<String>(article.description)
    val publishedAt = ObservableField<String>(article.publishedAt)

    fun onClick() {
        clickListener?.onItemClicked(article.url)
    }
}