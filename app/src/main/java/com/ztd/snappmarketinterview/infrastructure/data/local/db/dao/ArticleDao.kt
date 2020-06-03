package com.ztd.snappmarketinterview.infrastructure.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ztd.snappmarketinterview.infrastructure.data.model.db.ArticleEntity

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(articles: MutableList<ArticleEntity>)

    @Query("SELECT * FROM article WHERE source_id = :sourceId")
    fun loadAllBySource(sourceId:String): LiveData<MutableList<ArticleEntity>>?

    @Query("DELETE FROM article")
    fun deleteAll()
}