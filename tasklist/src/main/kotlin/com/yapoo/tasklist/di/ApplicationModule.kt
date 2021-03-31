package com.yapoo.tasklist.di

import com.yapoo.tasklist.data.di.RepositoryModule
import com.yapoo.tasklist.feature.user.di.UserExportToApplicationRegistry
import com.yapoo.tasklist.feature.user.di.UserModule
import com.yapoo.tasklist.infrastructure.di.InfrastructureExportToApplicationRegistry
import com.yapoo.tasklist.infrastructure.di.InfrastructureModule

class ApplicationModule private constructor(
    private val infrastructure: InfrastructureExportToApplicationRegistry,
    private val user: UserExportToApplicationRegistry
) :
    InfrastructureExportToApplicationRegistry by infrastructure,
    UserExportToApplicationRegistry by user {

    companion object {
        operator fun invoke(): ApplicationModule {
            val infrastructure = InfrastructureModule()
            val repository = RepositoryModule(infrastructure)
            val user = UserModule(repository)

            return ApplicationModule(
                infrastructure = infrastructure,
                user = user
            )
        }
    }
}
