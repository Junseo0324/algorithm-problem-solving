package BOJ.stack_queue

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue
import kotlin.math.abs

/**
 * 1. 배열에 정수x 를 넣음
 * 2. 배열에서 절댓값이 가장 작은 값 출력(가장 작은 값이 여러개 일 경우, 가장 작은 수) 후 배열에서 제거
 */
fun main() {
    var pq = PriorityQueue<Int> {o1,o2 -> if (abs(o1) == abs(o2)) o1-o2 else abs(o1) - abs(o2) }
    var n = readln().toInt()
    var answerList = mutableListOf<Int>()
    repeat(n) {
        var input = readln().toInt()
        if (pq.isNotEmpty()) {
            if (input != 0) {
                pq.offer(input)
            } else if (input == 0) {
                answerList.add(pq.poll())
            }
        } else {
            if (input !=0) {
                pq.offer(input)
            } else if (input == 0) {
                answerList.add(0)
            }
        }

    }
    println(answerList.joinToString("\n"))
}