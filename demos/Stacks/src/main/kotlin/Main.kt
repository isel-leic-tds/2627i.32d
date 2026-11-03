package palbp.demos.tds.isel

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val s1 = ImmutableStack<String>()

    try {
        s1.top
    }
    catch (e: NoSuchElementException) {
        println("Não páro porque não quero!")
    }

    val s2 = s1.push("SLB")

    println(s1.toString())
    println(s2.toString())


    val s3 = s2.push("O MAIOR")

    println(s1.toString())
    println(s2.toString())
    println(s3.toString())
}