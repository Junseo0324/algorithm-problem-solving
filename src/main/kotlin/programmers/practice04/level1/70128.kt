package programmers.practice04.level1

fun solution70128(a: IntArray, b: IntArray): Int {
    var answer = 0
    for (i in a.indices) {
        answer += a[i] * b[i]
    }
    return answer
}