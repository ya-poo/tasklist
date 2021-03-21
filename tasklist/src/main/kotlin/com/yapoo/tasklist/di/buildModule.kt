package com.yapoo.tasklist.di

import com.yapoo.tasklist.core.di.CoreModule
import com.yapoo.tasklist.core.di.DataModule
import com.yapoo.tasklist.core.di.toCoreExportToDataRegistry
import com.yapoo.tasklist.core.di.toDataExportToUserRegistry
import com.yapoo.tasklist.feature.user.di.UserModule

fun buildModule(): ApplicationModule {
    val core = CoreModule()
    val data = DataModule(core.toCoreExportToDataRegistry())
    val user = UserModule(data.toDataExportToUserRegistry())

    return ApplicationModule(
        core = core,
        data = data,
        user = user
    )
}
