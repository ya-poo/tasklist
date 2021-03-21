package com.yapoo.tasklist.core.di

import com.yapoo.tasklist.core.repository.UserRepository
import com.yapoo.tasklist.core.repository.UserRepositoryImpl

class DataModule(
    private val core: CoreExportToDataRegistry
) :
    DataModuleRegistry,
    DataExportToUserRegistry,
    CoreExportToDataRegistry by core {

    override val userRepository: UserRepository = UserRepositoryImpl(this)
}

fun DataModule.toUserExportRegistry(): DataExportToUserRegistry = this
