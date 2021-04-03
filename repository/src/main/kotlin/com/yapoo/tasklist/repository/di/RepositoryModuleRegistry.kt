package com.yapoo.tasklist.repository.di

import com.yapoo.tasklist.repository.repository.UserRepository
import com.yapoo.tasklist.infrastructure.di.InfrastructureExportToRepositoryRegistry

interface RepositoryModuleRegistry :
    InfrastructureExportToRepositoryRegistry,
    UserRepository.Dependency

interface RepositoryExportToUserRegistry {
    val userRepository: UserRepository
}
