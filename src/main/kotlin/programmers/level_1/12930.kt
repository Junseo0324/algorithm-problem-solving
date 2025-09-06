package programmers.level_1


// https://school.programmers.co.kr/learn/courses/30/lessons/12930?language=kotlin

fun solution12930(s: String): String {
    var answer =
        s.split(" ").map { it.mapIndexed { index, c ->
            if (index % 2 == 0) {
                c.uppercase()
            } else c.lowercase()
        } }.joinToString("")

    return answer
}


fun main() {
    println(solution12930("try hello world"))
}

