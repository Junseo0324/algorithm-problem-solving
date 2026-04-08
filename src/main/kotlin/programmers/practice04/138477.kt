package programmers.practice04

import java.util.PriorityQueue

fun main() {
    println(solution138477(k = 3, score = intArrayOf(10, 100, 20, 150, 1, 100, 200)))
    println(solution138477(k = 4, score = intArrayOf(0, 300, 40, 300, 20, 70, 150, 50, 500, 1000)))
}

fun solution138477(k: Int, score: IntArray): IntArray {
    var answer: IntArray = intArrayOf()
    val pq = PriorityQueue<Int>(3)

    for (sc in score) {
        if (pq.size < k) {
            pq.offer(sc)
        } else {
            if (pq.peek() < sc) {
                pq.poll()
                pq.offer(sc)
            }
        }
        answer += pq.peek()
    }
    return answer
}