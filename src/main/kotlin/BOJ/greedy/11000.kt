package BOJ.greedy

import java.util.PriorityQueue

/**
 * 3
 * 1 3
 * 2 4
 * 3 5
 */
fun main() {
    val n = readln().toInt()
    var array = mutableListOf<Pair<Int, Int>>()
    val queue = PriorityQueue<Pair<Int,Int>>(compareBy { it.second })
    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        array.add(x to y)
    }

    array = array.sortedWith(compareBy { it.first }).toMutableList()

    array.forEach { (x, y) ->
        if (queue.isNotEmpty()) {
            var (currX, currY) = queue.poll()
            if (currY <= x) {
                queue.offer(x to y)
            } else {
                queue.offer(currX to currY)
                queue.offer(x to y)
            }
        } else {
            queue.offer(x to y)
        }
    }

    println(queue.size)
}