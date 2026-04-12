package programmers.practice04.level1

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    repeat(b) {
        println("*".repeat(a))
    }
}