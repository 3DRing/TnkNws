package com.ringov.tnknws

import io.reactivex.Scheduler

data class RxSchedulers(val io: Scheduler, val mainThread: Scheduler)