package programmers.level_1

import java.time.LocalDate

// https://school.programmers.co.kr/learn/courses/30/lessons/12901

fun solution12901(a: Int, b: Int): String {
    return LocalDate.of(2016,a,b).dayOfWeek.name.take(3).uppercase()
}

fun main() {
    println(solution12901(5,31))
}