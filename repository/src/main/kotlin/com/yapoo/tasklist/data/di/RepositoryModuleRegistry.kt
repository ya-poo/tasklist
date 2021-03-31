package com.yapoo.tasklist.data.di

import com.yapoo.tasklist.data.repository.UserRepository
import com.yapoo.tasklist.infrastructure.di.InfrastructureExportToRepositoryRegistry

interface RepositoryModuleRegistry :
    InfrastructureExportToRepositoryRegistry,
    UserRepository.Dependency

interface RepositoryExportToUserRegistry {
    val userRepository: UserRepository
}
