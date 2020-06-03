package com.ztd.snappmarketinterview.infrastructure.utils

import io.reactivex.Scheduler

interface SchedulersProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}