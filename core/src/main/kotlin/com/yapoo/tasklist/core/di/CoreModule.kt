package com.yapoo.tasklist.core.di

import com.yapoo.tasklist.core.time.SystemClock
import com.yapoo.tasklist.core.time.SystemClockImpl

class CoreModule :
    CoreModuleRegistry,
    CoreExportToDataRegistry {

    override val systemClock: SystemClock = SystemClockImpl()
}

fun CoreModule.toCoreExportToDataRegistry() =
    object : CoreExportToDataRegistry by this {}
