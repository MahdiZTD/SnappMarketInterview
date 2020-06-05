package com.ztd.snappmarketinterview.mvvm.articlefragment

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import com.ztd.snappmarketinterview.R
import com.ztd.snappmarketinterview.databinding.FragmentArticleBinding
import com.ztd.snappmarketinterview.infrastructure.data.model.db.ArticleEntity
import com.ztd.snappmarketinterview.mvvm.articlefragment.adapter.NewsArticleAdapter
import com.ztd.snappmarketinterview.mvvm.base.BaseFragment
import javax.inject.Inject

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */
class ArticleFragment : BaseFragment<FragmentArticleBinding, ArticleViewModel>(), ArticleNavigator,
    NewsArticleAdapter.OnItemClickListener {

    @Inject
    lateinit var articleViewModel: ArticleViewModel

    @Inject
    lateinit var adapter: NewsArticleAdapter

    override val bindingVariable: Int
        get() = BR.vm
    override val layoutId: Int
        get() = R.layout.fragment_article
    override val mViewModel: ArticleViewModel
        get() = articleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialAdapter()
        subscribeToLiveData()

        mViewModel.apiGetNewsArticleBySource(ArticleFragmentArgs.fromBundle(requireArguments()).sourceId)
    }

    private fun initialAdapter() {
        adapter.clickListener = this
        viewDataBinding.rvArticle.adapter = adapter
    }

    private fun subscribeToLiveData() {

        mViewModel.databaseFetchNewsArticle(ArticleFragmentArgs.fromBundle(requireArguments()).sourceId)
            ?.observe(viewLifecycleOwner, Observer {
                mViewModel.articles.clear()
                mViewModel.articles.addAll(it)
            })

        mViewModel.articleLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                mViewModel.databaseSaveArticles(it.map { response ->
                    ArticleEntity(
                        null,
                        response.author,
                        response.content,
                        response.description,
                        response.publishedAt,
                        response.title,
                        response.url,
                        response.urlToImage,
                        response.source.id
                    )
                }.toMutableList())
            }
        })
    }

    override fun onItemClicked(articleUrl: String?) {

    }
}