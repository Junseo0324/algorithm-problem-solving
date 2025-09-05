package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12947?language=kotlin

fun solution12947(x: Int): Boolean {
    var harshad = x.toString().sumOf { it.digitToInt() }
    if (x % harshad ==0) return true

    return false
}


fun main() {
    println(solution12947(13))
}