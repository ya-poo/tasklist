package com.yapoo.tasklist.data.di

import com.yapoo.tasklist.infrastructure.di.InfrastructureExportToDataRegistry
import com.yapoo.tasklist.data.repository.UserRepository

interface DataModuleRegistry :
    InfrastructureExportToDataRegistry,
    UserRepository.Dependency

interface DataExportToUserRegistry {
    val userRepository: UserRepository
}
