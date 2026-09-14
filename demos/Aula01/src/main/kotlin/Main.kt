package palbp.demos.tds.isel


data class BadRobot(var model: String)

fun main() {

    val robot = BadRobot("R2D2")
    val robot3 = robot
    val robot2 = BadRobot("C3PO")

    println("robot: ${robot.model}")
    println("robot2: ${robot2.model}")
    println("robot3: ${robot3.model}")

    doSomethingWeirdWooooo(robot)

    println("robot: ${robot.model}")
    println("robot2: ${robot2.model}")
    println("robot3: ${robot3.model}")
}

fun doSomethingWeirdWooooo(robot: BadRobot) {
    robot.model = "BB8"
}
