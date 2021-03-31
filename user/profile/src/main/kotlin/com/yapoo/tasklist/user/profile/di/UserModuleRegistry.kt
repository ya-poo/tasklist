package com.yapoo.tasklist.user.profile.di

import com.yapoo.tasklist.user.profile.service.UserService
import com.yapoo.tasklist.user.profile.usecase.UserUseCase

interface UserModuleRegistry :
    UserUseCase.Dependency,
    UserService.Dependency

interface UserExportToApplicationRegistry {
    val userUseCase: UserUseCase
}
