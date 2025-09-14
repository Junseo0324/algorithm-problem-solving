package programmers.level_2

import java.util.LinkedList

// https://school.programmers.co.kr/learn/courses/30/lessons/42587?language=kotlin

/**
 * 1. 실행 대기 큐에서 대기중인 프로세스 하나를 꺼냄
 * 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 큐를 다시 넣음
 * 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스 실행
 */
fun solution42587(priorities: IntArray, location: Int): Int {
    val queue = LinkedList<Pair<Int,Int>>() //queue 에 넣어둔 순서 & 우선순위
    for (i in priorities.indices) {
        queue.add(Pair(i,priorities[i]))
    }
    var answer = 0

    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        if (queue.any { it.second > curr.second }) {
            queue.add(curr)
        } else {
            answer++
            if (curr.first == location) {
                return answer
            }
        }
    }
    return -1
}

fun main() {
    println(solution42587(intArrayOf(2,1,3,2),2))
    println(solution42587(intArrayOf(1,1,9,1,1,1),0))
}