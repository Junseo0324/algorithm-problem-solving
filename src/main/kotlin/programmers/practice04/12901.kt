package programmers.practice04

import java.time.LocalDate

fun main() {
    println(solution12901(5,24))
}

fun solution12901(a: Int, b: Int): String {
    return LocalDate.of(2016,a,b).dayOfWeek.toString().take(3)
}