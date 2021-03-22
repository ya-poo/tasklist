package com.yapoo.tasklist.infrastructure.di

import com.yapoo.tasklist.core.repository.UserRepository

interface DataModuleRegistry :
    InfrastructureExportToDataRegistry,
    UserRepository.Dependency

interface DataExportToUserRegistry {
    val userRepository: UserRepository
}
