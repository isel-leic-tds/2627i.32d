package palbp.demos.tds.isel.hellocompose

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() {
    println("Main starts in thread ${Thread.currentThread().name}")

    application {
        println("Application starts ${Thread.currentThread().name}")

        Window(
            onCloseRequest = {
                println("onCloseRequest running in thread ${Thread.currentThread().name}")
                exitApplication()
            },
            title = "SLB O MAIOR !!!",
        ) {
            App()
        }

        println("Application ends ${Thread.currentThread().name}")
    }

    println("Main ends in thread ${Thread.currentThread().name}")
}