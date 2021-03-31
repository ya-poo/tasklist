package com.yapoo.tasklist.data.di

import com.yapoo.tasklist.data.repository.UserRepository
import com.yapoo.tasklist.data.repository.UserRepositoryImpl
import com.yapoo.tasklist.infrastructure.di.InfrastructureExportToDataRegistry

class RepositoryModule(
    private val infrastructure: InfrastructureExportToDataRegistry
) :
    RepositoryModuleRegistry,
    RepositoryExportToUserRegistry,
    InfrastructureExportToDataRegistry by infrastructure {

    override val userRepository: UserRepository by lazy { UserRepositoryImpl(this) }
}
