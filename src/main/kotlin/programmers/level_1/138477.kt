package programmers.level_1

import java.util.PriorityQueue


// https://school.programmers.co.kr/learn/courses/30/lessons/138477

/**
 * 상위k 이내 -> 명예의 전당
 * answer = 명예의 전당 최하위 점수
 */
fun solution138477(k: Int, score: IntArray): IntArray {
    var answer: IntArray = intArrayOf()
    var pq = PriorityQueue<Int>()
    for (i in score.indices) {
        if (pq.size < k) {
            pq.add(score[i])
        } else {
            if (pq.peek() < score[i]) {
                pq.poll()
                pq.add(score[i])
            }
        }
        answer += pq.peek()
    }
    return answer
}

fun main() {
    println(solution138477(3, intArrayOf(10, 100, 20, 150, 1, 100, 200)))
}