package com.ringov.tnknws.utils

import io.reactivex.Scheduler

data class RxSchedulers(val io: Scheduler, val mainThread: Scheduler)