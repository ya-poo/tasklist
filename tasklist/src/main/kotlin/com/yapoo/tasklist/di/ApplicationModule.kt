package com.yapoo.tasklist.di

import com.yapoo.tasklist.repository.di.RepositoryModule
import com.yapoo.tasklist.infrastructure.di.InfrastructureExportToApplicationRegistry
import com.yapoo.tasklist.infrastructure.di.InfrastructureModule
import com.yapoo.tasklist.user.profile.di.UserExportToApplicationRegistry
import com.yapoo.tasklist.user.profile.di.UserModule

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
