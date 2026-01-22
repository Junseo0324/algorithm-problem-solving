package BOJ.implementation

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }

    println("${arr.min()} ${arr.max()}")
}