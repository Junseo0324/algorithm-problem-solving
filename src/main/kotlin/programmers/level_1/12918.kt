package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12918

fun solution12918(s: String): Boolean {
    if (s.length == 4 || s.length == 6) {
        if (s.count { it.isDigit() } == s.length) {
            return true
        }
    }
    return false
}

fun main() {
    println(solution12918("1234"))
}