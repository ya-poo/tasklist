package com.yapoo.tasklist.data.di

import com.yapoo.tasklist.infrastructure.di.InfrastructureExportToDataRegistry
import com.yapoo.tasklist.data.repository.UserRepository
import com.yapoo.tasklist.data.repository.UserRepositoryImpl

class DataModule(
    private val infrastructure: InfrastructureExportToDataRegistry
) :
    DataModuleRegistry,
    DataExportToUserRegistry,
    InfrastructureExportToDataRegistry by infrastructure {

    override val userRepository: UserRepository by lazy { UserRepositoryImpl(this) }
}
