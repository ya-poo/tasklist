package com.yapoo.tasklist.user.profile.di

import com.yapoo.tasklist.model.di.RepositoryExportToUserRegistry
import com.yapoo.tasklist.user.profile.service.UserService
import com.yapoo.tasklist.user.profile.service.UserServiceImpl
import com.yapoo.tasklist.user.profile.usecase.UserUseCase
import com.yapoo.tasklist.user.profile.usecase.UserUseCaseImpl

class UserModule(
    private val repository: RepositoryExportToUserRegistry
) : UserModuleRegistry,
    UserExportToApplicationRegistry,
    RepositoryExportToUserRegistry by repository {

    override val userUseCase: UserUseCase by lazy { UserUseCaseImpl(this) }

    override val userService: UserService by lazy { UserServiceImpl(this) }
}
