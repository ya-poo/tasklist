package com.yapoo.tasklist.infrastructure.di

import com.yapoo.tasklist.core.repository.UserRepository
import com.yapoo.tasklist.core.repository.UserRepositoryImpl

class DataModule(
    private val infrastructure: InfrastructureExportToDataRegistry
) :
    DataModuleRegistry,
    DataExportToUserRegistry,
    InfrastructureExportToDataRegistry by infrastructure {

    override val userRepository: UserRepository by lazy { UserRepositoryImpl(this) }
}
