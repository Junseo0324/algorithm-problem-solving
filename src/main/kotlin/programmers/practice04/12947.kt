package programmers.practice04

fun solution12947(x: Int): Boolean {
    val target = x.toString().map { it.digitToInt() }.sum()
    return x % target == 0
}