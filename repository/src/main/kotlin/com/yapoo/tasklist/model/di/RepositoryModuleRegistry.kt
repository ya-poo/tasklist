package com.yapoo.tasklist.model.di

import com.yapoo.tasklist.model.repository.UserRepository
import com.yapoo.tasklist.infrastructure.di.InfrastructureExportToRepositoryRegistry

interface RepositoryModuleRegistry :
    InfrastructureExportToRepositoryRegistry,
    UserRepository.Dependency

interface RepositoryExportToUserRegistry {
    val userRepository: UserRepository
}
