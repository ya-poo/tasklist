package com.yapoo.tasklist.di

import com.yapoo.tasklist.core.di.CoreModule
import com.yapoo.tasklist.core.di.DataModule
import com.yapoo.tasklist.feature.user.di.UserModule

class ApplicationModule(
    val core: CoreModule,
    val data: DataModule,
    val user: UserModule
)
