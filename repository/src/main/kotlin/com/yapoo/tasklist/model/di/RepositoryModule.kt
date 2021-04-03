package com.yapoo.tasklist.model.di

import com.yapoo.tasklist.model.repository.UserRepository
import com.yapoo.tasklist.model.repository.UserRepositoryImpl
import com.yapoo.tasklist.infrastructure.di.InfrastructureExportToRepositoryRegistry

class RepositoryModule(
    private val infrastructure: InfrastructureExportToRepositoryRegistry
) :
    RepositoryModuleRegistry,
    RepositoryExportToUserRegistry,
    InfrastructureExportToRepositoryRegistry by infrastructure {

    override val userRepository: UserRepository by lazy { UserRepositoryImpl(this) }
}
