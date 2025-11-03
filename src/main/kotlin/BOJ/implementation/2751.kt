package BOJ.implementation

fun main() {
    val n = readln().toInt()
    val array = List(n) { readln().toInt() }

    println(array.sorted().joinToString("\n"))
}