package com.yapoo.tasklist.di

import com.yapoo.tasklist.core.di.CoreExportToApplicationRegistry
import com.yapoo.tasklist.core.di.CoreModule
import com.yapoo.tasklist.core.di.DataModule
import com.yapoo.tasklist.feature.user.di.UserExportToApplicationRegistry
import com.yapoo.tasklist.feature.user.di.UserModule

class ApplicationModule private constructor(
    private val core: CoreExportToApplicationRegistry,
    private val user: UserExportToApplicationRegistry
) :
    CoreExportToApplicationRegistry by core,
    UserExportToApplicationRegistry by user {

    companion object {
        operator fun invoke(): ApplicationModule {
            val core = CoreModule()
            val data = DataModule(core)
            val user = UserModule(data)

            return ApplicationModule(
                core = core,
                user = user
            )
        }
    }
}
