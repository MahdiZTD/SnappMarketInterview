package com.ztd.snappmarketinterview.infrastructure.data.local.preference

import android.content.Context
import android.content.SharedPreferences
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Mahdi Zare Tahghigh Doost on 5/10/2020.
 *
 * mahdiZTD@gmail.com
 */

interface PreferenceHelper {


    fun saveApiCallTimeBySource(source: String, time: Long)

    fun hasApiCallInPast(source: String): Boolean

}

@Singleton
class PreferenceHelperImp @Inject constructor(context: Context) : PreferenceHelper {

    companion object {
        const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
    }

    private val mPrefs: SharedPreferences =
        context.getSharedPreferences("GUNG_HO_PREF", Context.MODE_PRIVATE)


    override fun saveApiCallTimeBySource(source: String, time: Long) {
        mPrefs.edit().putLong(source, time).apply()
    }

    override fun hasApiCallInPast(source: String): Boolean {
        val lastCall = mPrefs.getLong(source, 0)
        return TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - lastCall) >= 15
    }


}