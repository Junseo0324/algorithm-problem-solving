package BOJ.greedy

import java.util.PriorityQueue

fun main() {
    var n = readln().toInt()
    val plusPq = PriorityQueue<Int>(reverseOrder())
    val minusPq = PriorityQueue<Int>()
    var oneCount = 0
    var zeroCount = 0


    repeat(n) {
        var input = readln().toInt()
        when {
         input > 1 -> plusPq.offer(input)
         input == 1 -> oneCount++
         input == 0 -> zeroCount++
         else -> minusPq.offer(input)
        }
    }
    var sum = 0
    while (plusPq.size > 1) {
        val first = plusPq.poll()
        val second = plusPq.poll()
        sum += first*second
    }
    if (plusPq.isNotEmpty()) {
        sum+=plusPq.poll()
    }

    while (minusPq.size >1) {
        val first = minusPq.poll()
        val second = minusPq.poll()
        sum+=first*second
    }
    if (minusPq.isNotEmpty()) {
        if (zeroCount ==0) {
            sum += minusPq.poll()
        }
    }
    sum+=oneCount
    println(sum)




}