package com.yapoo.tasklist.repository.di

import com.yapoo.tasklist.repository.repository.UserRepository
import com.yapoo.tasklist.repository.repository.UserRepositoryImpl
import com.yapoo.tasklist.infrastructure.di.InfrastructureExportToRepositoryRegistry

class RepositoryModule(
    private val infrastructure: InfrastructureExportToRepositoryRegistry
) :
    RepositoryModuleRegistry,
    RepositoryExportToUserRegistry,
    InfrastructureExportToRepositoryRegistry by infrastructure {

    override val userRepository: UserRepository by lazy { UserRepositoryImpl(this) }
}
