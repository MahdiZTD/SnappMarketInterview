package com.ztd.snappmarketinterview.mvvm.sourcesfragment.adapter

import androidx.databinding.ObservableField
import com.ztd.snappmarketinterview.infrastructure.data.model.db.SourceEntity

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */
class NewsSourceItemViewModel(
    private val source: SourceEntity,
    private val clickListener: NewsSourceAdapter.OnItemClickListener?
) {

    val name = ObservableField<String>(source.name)
    val category = ObservableField<String>(source.category)
    val description = ObservableField<String>(source.description)

    fun onClick() {
        clickListener?.onItemClicked(source.id, source.name)
    }
}