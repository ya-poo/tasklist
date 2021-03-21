package com.yapoo.tasklist.core.di

import com.yapoo.tasklist.core.time.SystemClock

interface CoreModuleRegistry

interface CoreExportToDataRegistry {

    val systemClock: SystemClock

}
