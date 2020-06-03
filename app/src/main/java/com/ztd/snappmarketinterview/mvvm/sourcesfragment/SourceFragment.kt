package com.ztd.snappmarketinterview.mvvm.sourcesfragment

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ztd.snappmarketinterview.R
import com.ztd.snappmarketinterview.databinding.FragmentSourceBinding
import com.ztd.snappmarketinterview.mvvm.base.BaseFragment
import com.ztd.snappmarketinterview.mvvm.sourcesfragment.adapter.NewsSourceAdapter
import javax.inject.Inject

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */
class SourceFragment : BaseFragment<FragmentSourceBinding, SourceViewModel>(), SourceNavigator,
    NewsSourceAdapter.OnItemClickListener {

    @Inject
    lateinit var sourceViewModel: SourceViewModel

    @Inject
    lateinit var adapter: NewsSourceAdapter

    override val bindingVariable: Int
        get() = BR.vm
    override val layoutId: Int
        get() = R.layout.fragment_source
    override val mViewModel: SourceViewModel
        get() = sourceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialRecyclerView()
        mViewModel.apiGetNewsHeadlines()
        subscribeToLiveData()
    }

    private fun initialRecyclerView() {
        adapter.clickListener = this
        viewDataBinding.rvSource.adapter = adapter
    }

    private fun subscribeToLiveData() {
        mViewModel.databaseFetchNewsSources()?.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                mViewModel.sources.clear()
                mViewModel.sources.addAll(it)
            }
        })

        mViewModel.sourceLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                mViewModel.databaseSaveSources(it)
            }
        })
    }

    override fun onItemClicked(sourceId: String, sourceName: String?) {
        findNavController().navigate(
            SourceFragmentDirections.actionSourceFragmentToArticleFragment(
                sourceId,
                sourceName?:""
            )
        )
    }

}