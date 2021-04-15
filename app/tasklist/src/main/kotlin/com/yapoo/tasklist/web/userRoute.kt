package com.yapoo.tasklist.web

import com.yapoo.tasklist.di.ApplicationModule
import com.yapoo.tasklist.user.profile.route.profileRoute
import io.ktor.routing.*

fun Route.userRoute(module: ApplicationModule) = module.run {
    route("users/me") {
        profileRoute(userUseCase)
    }
}
