package palbp.demos.tds.isel.hellocompose

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform