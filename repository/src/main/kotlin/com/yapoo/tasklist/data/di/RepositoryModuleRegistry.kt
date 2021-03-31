package com.yapoo.tasklist.data.di

import com.yapoo.tasklist.data.repository.UserRepository
import com.yapoo.tasklist.infrastructure.di.InfrastructureExportToDataRegistry

interface RepositoryModuleRegistry :
    InfrastructureExportToDataRegistry,
    UserRepository.Dependency

interface RepositoryExportToUserRegistry {
    val userRepository: UserRepository
}
