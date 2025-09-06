package programmers.level_1


// https://school.programmers.co.kr/learn/courses/30/lessons/12917?language=kotlin


fun solution12917(s: String): String {
    return s.toCharArray().sortedDescending().joinToString("")
}

fun main() {
    println(solution12917("Zbcdefg"))
}