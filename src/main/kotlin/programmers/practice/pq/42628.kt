package programmers.practice.pq

import java.util.PriorityQueue

fun main() {
    println(
        solution42628(
            operations = arrayOf(
                "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"
            )
        )
    )
    println(
        solution42628(
            operations = arrayOf(
                "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"
            )
        )
    )
}

fun solution42628(operations: Array<String>): MutableList<Int> {
    val answer = mutableListOf<Int>()
    val minPq = PriorityQueue<Int>(compareBy { it })
    val maxPq = PriorityQueue<Int>(compareByDescending { it })

    var idx = 0

    while (true) {
        val (operator, num) = operations[idx].split(" ")
        val number = num.toInt()
        when (operator) {
            "I" -> {
                minPq.offer(number)
                maxPq.offer(number)
            }
            "D" -> {
                if (minPq.isNotEmpty() && maxPq.isNotEmpty()) {
                    if (number < 0) {
                        val target = minPq.poll()
                        maxPq.remove(target)
                    } else {
                        val target = maxPq.poll()
                        minPq.remove(target)
                    }
                }
            }
        }
        idx++

        if (idx >= operations.size) {
            break
        }
    }
    if (maxPq.isNotEmpty() && minPq.isNotEmpty()) {
        answer += maxPq.first()
        answer += minPq.first()
    } else {
        answer += 0
        answer += 0
    }
    return answer
}