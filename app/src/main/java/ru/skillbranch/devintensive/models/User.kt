package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
) {
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id,
        firstName,
        lastName,
        null
    )

    companion object Factory {
        private var lastId: AtomicInteger = AtomicInteger(-1)

        fun makeUser(fullName: String?): User = Utils.parseFullName(fullName).let {
            User((lastId.incrementAndGet()).toString(), it.first, it.second)
        }
    }
}