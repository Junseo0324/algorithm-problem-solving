package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/132267

/**
 * 총 빈 병의 수, total , 남은 병 수
 * -----
 * a = 3,  b = 1, n = 20
 * remain = 20, change = 18 (ax6), total = 6,
 * remain = 2 + 6 = 8, change = 6(ax2) , total = 2,
 * remain = 8 - 6 + 2 = 4, change = 3(ax1), total = 1,
 * remain = 4 - 3 + 1 = 2, change = 0, total = 0,
 * remain = 2, change = 0,
 * -----
 */

fun solution132267(a: Int, b: Int, n: Int): Int {
    var answer = 0
    var remain = n
    while (true) {
        if (remain < a)
            break
        val change = remain / a * b
        answer += change
        remain = remain%a + change
    }
    return answer
}

fun main() {
    println(solution132267(3, 2, 20))
}