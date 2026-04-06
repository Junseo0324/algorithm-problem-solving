package programmers.practice04

fun main() {
    println(solution12931(123))
    println(solution12931(987))
}

fun solution12931(n: Int): Int {
    val list = n.toString().map { it.digitToInt() }.sum()
    return list
}