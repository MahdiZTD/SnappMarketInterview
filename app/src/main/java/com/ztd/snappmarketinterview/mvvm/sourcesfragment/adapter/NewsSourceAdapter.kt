package com.ztd.snappmarketinterview.mvvm.sourcesfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ztd.snappmarketinterview.databinding.ItemNewsSourceBinding
import com.ztd.snappmarketinterview.infrastructure.data.model.db.SourceEntity
import com.ztd.snappmarketinterview.mvvm.base.BaseViewHolder

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */
class NewsSourceAdapter(val sources: MutableList<SourceEntity>) :
    RecyclerView.Adapter<NewsSourceAdapter.SourceViewHolder>() {

    var clickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceViewHolder {
        return SourceViewHolder(
            ItemNewsSourceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = sources.size

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) = holder.onBind(position)

    fun addItems(sources: MutableList<SourceEntity>) {
        this.sources.clear()
        this.sources.addAll(sources)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.sources.clear()
    }


    inner class SourceViewHolder(private val mBinding: ItemNewsSourceBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            mBinding.vm = NewsSourceItemViewModel(sources[position],clickListener)
            mBinding.executePendingBindings()
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(sourceId: String, sourceName: String?)
    }

}