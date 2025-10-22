package BOJ.deque

// https://www.acmicpc.net/problem/1021

fun main() {
    val (n, _) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val deque = ArrayDeque((1..n).toList())
    var answer = 0
    list.forEach {
        var mid: Int
        while (true) {
            if (it == deque.first()) {
                deque.removeFirst()
                break
            }
            mid = deque.size / 2
            if (deque.indexOf(it) > mid) {
                val last = deque.removeLast()
                deque.addFirst(last)
                answer++
            } else {
                val first = deque.removeFirst()
                deque.addLast(first)
                answer++
            }
        }
    }
    println(answer)
}