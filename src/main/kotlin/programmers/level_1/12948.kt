package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12948

fun solution12948(phone_number: String): String {
    var last_number = phone_number.substring(phone_number.length-4,phone_number.length)
    return "*".repeat(phone_number.length-4) + last_number
}

fun main() {
    println(solution12948("01033334444"))
}