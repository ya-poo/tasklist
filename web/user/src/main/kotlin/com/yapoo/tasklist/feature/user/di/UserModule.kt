package com.yapoo.tasklist.feature.user.di

import com.yapoo.tasklist.data.di.RepositoryExportToUserRegistry
import com.yapoo.tasklist.feature.user.service.UserService
import com.yapoo.tasklist.feature.user.service.UserServiceImpl
import com.yapoo.tasklist.feature.user.usecase.UserUseCase
import com.yapoo.tasklist.feature.user.usecase.UserUseCaseImpl

class UserModule(
    private val repository: RepositoryExportToUserRegistry
) : UserModuleRegistry,
    UserExportToApplicationRegistry,
    RepositoryExportToUserRegistry by repository {

    override val userUseCase: UserUseCase by lazy { UserUseCaseImpl(this) }

    override val userService: UserService by lazy { UserServiceImpl(this) }
}
