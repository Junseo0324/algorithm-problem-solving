package programmers.practice.stack

fun main() {
    println(
        solution42583(
            bridge_length = 2,
            weight = 10,
            truck_weights = intArrayOf(7, 4, 5, 6)
        )
    )
    println(
        solution42583(
            bridge_length = 100,
            weight = 100,
            truck_weights = intArrayOf(10)
        )
    )
    println(
        solution42583(
            bridge_length = 100,
            weight = 100,
            truck_weights = intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
        )
    )
}

fun solution42583(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    var answer = 0 // 초 기록
    val trucks = ArrayDeque<Int>()
    val queue = ArrayDeque<Int>()
    for (truck in truck_weights) {
        trucks.addLast(truck)
    }

    repeat(bridge_length) {
        queue.addLast(0)
    }

    while (trucks.isNotEmpty() || queue.isNotEmpty()) {
        if (trucks.isNotEmpty()) {
            val curr = trucks.removeFirst()
            queue.removeFirst()
            answer++
            if (queue.sum() + curr <= weight) {
                queue.addLast(curr)
            } else {
                queue.addLast(0)
                trucks.addFirst(curr)
            }
        } else {
            answer++
            queue.removeFirst()
        }

    }

    return answer
}