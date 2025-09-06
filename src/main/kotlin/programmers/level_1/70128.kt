package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/70128

fun solution70128(a: IntArray, b: IntArray): Int {
    var answer = 0
    for (i in a.indices) {
        answer += a[i] * b[i]
    }
    return answer
}

fun main() {
    println(solution70128(intArrayOf(1,2,3,4), intArrayOf(-3,-1,0,2)))
}