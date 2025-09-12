package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/42747?language=kotlin

/**
 * citations n 편 중 h번 이상 인용된 논문이 h편 이상이고 나머지가 h번 이하 인용 -> max(h) 는 H-index
 *
 * 1<=n<=1000
 * 6,5,3,1,0
 */

fun solution42747(citations: IntArray): Int {
    var answer = 0
    val sorted = citations.sortedDescending()
    for (citation in sorted) {
        if (citation > answer) {
            answer+=1
        }
    }
    return answer
}

fun main() {
    println(solution42747(intArrayOf(3,0,6,1,5)))
}