package io.github.andreypfau.tonkotlinmppexample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform