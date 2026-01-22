package BOJ.implementation

fun main() {
    val array = readln().split(" ").map { it.reversed().toInt() }

    println(array.max())
}