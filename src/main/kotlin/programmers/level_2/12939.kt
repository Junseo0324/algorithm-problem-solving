package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/12939

fun solution12939(s: String): String {
    var answer = mutableListOf<Int>()
    var list = s.split(" ").map { it.toInt() }
    answer.add(list.minOf { it })
    answer.add(list.maxOf { it })
    return answer.joinToString(" ")
}

fun main() {
    println(solution12939("1 2 3 4"))
}