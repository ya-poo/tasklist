package com.yapoo.tasklist.di

import com.yapoo.tasklist.infrastructure.di.InfrastructureExportToApplicationRegistry
import com.yapoo.tasklist.infrastructure.di.InfrastructureModule
import com.yapoo.tasklist.data.di.DataModule
import com.yapoo.tasklist.feature.user.di.UserExportToApplicationRegistry
import com.yapoo.tasklist.feature.user.di.UserModule

class ApplicationModule private constructor(
    private val infrastructure: InfrastructureExportToApplicationRegistry,
    private val user: UserExportToApplicationRegistry
) :
    InfrastructureExportToApplicationRegistry by infrastructure,
    UserExportToApplicationRegistry by user {

    companion object {
        operator fun invoke(): ApplicationModule {
            val infrastructure = InfrastructureModule()
            val data = DataModule(infrastructure)
            val user = UserModule(data)

            return ApplicationModule(
                infrastructure = infrastructure,
                user = user
            )
        }
    }
}
