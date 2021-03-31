package com.yapoo.tasklist.route

import com.yapoo.tasklist.di.ApplicationModule
import com.yapoo.tasklist.user.profile.route.profileRoute
import io.ktor.routing.*

fun Route.userRoute(module: ApplicationModule) = module.run {
    route("users/me") {
        profileRoute(userUseCase)
    }
}
