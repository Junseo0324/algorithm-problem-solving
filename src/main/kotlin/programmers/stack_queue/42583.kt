package programmers.stack_queue

// https://school.programmers.co.kr/learn/courses/30/lessons/42583?language=kotlin

/**
 * 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너야 한다.
 * 다리에는 트럭이 최대 bridge_length 까지 가능 / weight까지 무게를 견딜 수 있음
 * 트럭 7,4,5,6 -> 10kg / 2대
 * 몇 초가 걸리는지 return
 * bridge < 10000  // weight < 10000  // truck_weight < 10000
 */

fun solution42583(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    var answer = 0
    val bridge = ArrayDeque(List(bridge_length) {0})
    val waiting = ArrayDeque(truck_weights.toList())
    var bridgeWeight = 0

    while (bridge.isNotEmpty()) {
        answer++
        bridgeWeight -= bridge.removeFirst()

        if (waiting.isNotEmpty()) {
            val curr = waiting.first()
            if (bridgeWeight + curr <= weight) {
                bridgeWeight += curr
                bridge.addLast(waiting.removeFirst())
            } else {
                bridge.addLast(0)
            }
        }

        if (waiting.isEmpty() && bridge.all { it == 0 }) break

    }
    return answer
}

fun main() {
    println(solution42583(2,10, intArrayOf(7,4,5,6)))
    println(solution42583(100,100, intArrayOf(10)))
    println(solution42583(100,100, intArrayOf(10,10,10,10,10,10,10,10,10,10)))
}