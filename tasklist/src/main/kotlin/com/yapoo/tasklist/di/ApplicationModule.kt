package com.yapoo.tasklist.di

import com.yapoo.tasklist.core.di.*
import com.yapoo.tasklist.feature.user.di.UserExportToApplicationRegistry
import com.yapoo.tasklist.feature.user.di.UserModule
import com.yapoo.tasklist.feature.user.di.toApplicationExportRegistry

class ApplicationModule private constructor(
    private val core: CoreExportToApplicationRegistry,
    private val user: UserExportToApplicationRegistry
) :
    CoreExportToApplicationRegistry by core,
    UserExportToApplicationRegistry by user {

    companion object {
        operator fun invoke(): ApplicationModule {
            val core = CoreModule()
            val data = DataModule(core.toDataExportRegistry())
            val user = UserModule(data.toUserExportRegistry())

            return ApplicationModule(
                core = core.toApplicationExportRegistry(),
                user = user.toApplicationExportRegistry()
            )
        }
    }
}
