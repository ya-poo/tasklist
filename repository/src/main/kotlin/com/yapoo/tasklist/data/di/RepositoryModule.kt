package com.yapoo.tasklist.data.di

import com.yapoo.tasklist.data.repository.UserRepository
import com.yapoo.tasklist.data.repository.UserRepositoryImpl
import com.yapoo.tasklist.infrastructure.di.InfrastructureExportToRepositoryRegistry

class RepositoryModule(
    private val infrastructure: InfrastructureExportToRepositoryRegistry
) :
    RepositoryModuleRegistry,
    RepositoryExportToUserRegistry,
    InfrastructureExportToRepositoryRegistry by infrastructure {

    override val userRepository: UserRepository by lazy { UserRepositoryImpl(this) }
}
