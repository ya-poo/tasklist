package com.yapoo.tasklist.feature.user.di

import com.yapoo.tasklist.core.di.DataExportToUserRegistry
import com.yapoo.tasklist.feature.user.service.UserService
import com.yapoo.tasklist.feature.user.service.UserServiceImpl
import com.yapoo.tasklist.feature.user.usecase.UserUseCase
import com.yapoo.tasklist.feature.user.usecase.UserUseCaseImpl

class UserModule(
    private val data: DataExportToUserRegistry
) : UserModuleRegistry,
    UserExportToApplicationRegistry,
    DataExportToUserRegistry by data {

    override val userUseCase: UserUseCase = UserUseCaseImpl(this)

    override val userService: UserService = UserServiceImpl(this)
}

fun UserModule.toApplicationExportRegistry(): UserExportToApplicationRegistry = this
