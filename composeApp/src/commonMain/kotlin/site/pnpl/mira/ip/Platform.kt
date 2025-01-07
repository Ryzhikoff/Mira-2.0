package site.pnpl.mira.ip

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform