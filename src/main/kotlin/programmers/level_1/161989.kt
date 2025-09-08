package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/161989?language=kotlin
/**
 * n = 벽 길이
 * 구역 번호 : 1~n (idx+1)
 * m = 롤러 길이
 * 페인트질의 최소 횟수
 */
fun solution161989(n: Int, m: Int, section: IntArray): Int {
    var answer = 0
    var paint = BooleanArray(n) { true }
    section.forEach {
        paint[it - 1] = false
    }
    for (i in paint.indices) {
        if (!paint[i]) {
            for (j in i until i+m) {
                if (j >= paint.size) break
                paint[j] = true
            }
            answer+=1
        }
    }
    return answer
}

fun main() {
    println(solution161989(5, 4, intArrayOf(1, 3)))
}