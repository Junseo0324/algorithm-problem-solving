package BOJ.greedy

import java.util.PriorityQueue

/**
 *
 */
fun main() {
    var n = readln().toInt()
    var pq = PriorityQueue<Int>()

    repeat(n) {
        pq.offer(readln().toInt())
    }
    var sum = 0
    while (pq.size >=2) {
        val temp = pq.poll() + pq.poll()
        pq.offer(temp)
        sum+=temp
    }
    println(sum)
}