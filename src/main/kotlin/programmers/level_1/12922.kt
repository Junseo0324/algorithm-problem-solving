package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12922

fun solution12922(n: Int): String {
    return if (n %2 ==0) "수박".repeat(n/2) else "수" + "박수".repeat(n/2)
}


fun main() {
    println(solution12922(2))
}