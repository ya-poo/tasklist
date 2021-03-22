package com.yapoo.tasklist.feature.user.web.request

import com.yapoo.tasklist.data.valueobject.Email
import com.yapoo.tasklist.data.valueobject.UserName

data class UserRequest(
    val email: Email,
    val name: RequestName,
) {

    data class RequestName(
        val fullName: UserName,
        val kanaName: UserName
    )
}
