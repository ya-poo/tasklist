package com.yapoo.tasklist.core.di

import com.yapoo.tasklist.core.repository.UserRepository

interface DataModuleRegistry :
    CoreExportToDataRegistry,
    UserRepository.Dependency

interface DataExportToUserRegistry {
    val userRepository: UserRepository
}
