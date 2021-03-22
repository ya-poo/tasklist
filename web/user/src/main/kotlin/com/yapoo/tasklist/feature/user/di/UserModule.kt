package com.yapoo.tasklist.feature.user.di

import com.yapoo.tasklist.data.di.DataExportToUserRegistry
import com.yapoo.tasklist.feature.user.service.UserService
import com.yapoo.tasklist.feature.user.service.UserServiceImpl
import com.yapoo.tasklist.feature.user.usecase.UserUseCase
import com.yapoo.tasklist.feature.user.usecase.UserUseCaseImpl

class UserModule(
    private val data: DataExportToUserRegistry
) : UserModuleRegistry,
    UserExportToApplicationRegistry,
    DataExportToUserRegistry by data {

    override val userUseCase: UserUseCase by lazy { UserUseCaseImpl(this) }

    override val userService: UserService by lazy { UserServiceImpl(this) }
}
