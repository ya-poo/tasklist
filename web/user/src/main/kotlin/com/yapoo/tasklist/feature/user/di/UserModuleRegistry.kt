package com.yapoo.tasklist.feature.user.di

import com.yapoo.tasklist.feature.user.service.UserService
import com.yapoo.tasklist.feature.user.usecase.UserUseCase

interface UserModuleRegistry :
    UserUseCase.Dependency,
    UserService.Dependency
