package programmers.level_2


// https://school.programmers.co.kr/learn/courses/30/lessons/42583


/**
 * 트럭 여러 대가 가로지르는 일차선 다리를 정해진 순서대로 지나가려고 한다.
 * 모든 트럭이 다리를 지나려면 몇 초가 걸리느냐? (answer)
 * 최대 bridge_length 대 올라갈 수 있다.
 * 다리는 weight 이하까지만 견딜 수 있음. / 단, 다리에 완전히 오르지 않은 트럭의 무게 무시
 * 2대, 10kg ,, 트럭 [7kg,4kg,5kg, 6kg] 이 존재
 *
 */


fun solution42583(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    var answer = 0
    val bridge : ArrayDeque<Int> = ArrayDeque(List(bridge_length) { 0 })
    val waiting: ArrayDeque<Int> = ArrayDeque(truck_weights.toList())

    var total = 0
    while (bridge.isNotEmpty()) {
        answer++
        total -= bridge.removeFirst()

        if (waiting.isNotEmpty()) {
            val next = waiting.first()
            if (total + next <= weight) {
                total += next
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
    println(
        solution42583(
            2,10, intArrayOf(7,4,5,6)
        )
    )
}