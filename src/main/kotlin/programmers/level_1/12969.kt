package programmers.level_1


// https://school.programmers.co.kr/learn/courses/30/lessons/12969

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    repeat(b) {
        print("*".repeat(a)+"\n")
    }
}