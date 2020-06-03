package com.ztd.snappmarketinterview.infrastructure.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ztd.snappmarketinterview.infrastructure.data.model.db.ArticleEntity
import com.ztd.snappmarketinterview.infrastructure.data.model.db.SourceEntity

/**
 * Created by Mahdi Zare Tahghigh Doost on 6/3/2020.
 *
 * mahdiZTD@gmail.com
 */
@Dao
interface SourceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(sources: MutableList<SourceEntity>)

    @Query("SELECT * FROM source")
    fun loadAll(): LiveData<MutableList<SourceEntity>>

    @Query("DELETE FROM source")
    fun deleteAll()
}