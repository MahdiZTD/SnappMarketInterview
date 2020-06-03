package com.ztd.snappmarketinterview.infrastructure.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ztd.snappmarketinterview.infrastructure.data.local.db.dao.ArticleDao
import com.ztd.snappmarketinterview.infrastructure.data.local.db.dao.SourceDao
import com.ztd.snappmarketinterview.infrastructure.data.model.db.ArticleEntity
import com.ztd.snappmarketinterview.infrastructure.data.model.db.SourceEntity


@Database(
    entities = [ArticleEntity::class, SourceEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao?
    abstract fun sourceDao(): SourceDao?
}