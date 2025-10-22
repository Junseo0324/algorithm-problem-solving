package BOJ.deque

// https://www.acmicpc.net/problem/10866

fun main() {
    val n = readln().toInt()
    val deque = ArrayDeque<Int>()
    val list = mutableListOf<Int>()
    repeat(n) {
        var input = readln().split(" ")
        when(input[0]) {
            "push_back" -> deque.addLast(input[1].toInt())
            "push_front" -> deque.addFirst(input[1].toInt())
            "pop_front" -> if (deque.isEmpty()) list.add(-1) else list.add(deque.removeFirst())
            "pop_back" -> if (deque.isEmpty()) list.add(-1) else list.add(deque.removeLast())
            "size" -> list.add(deque.size)
            "empty" -> if (deque.isEmpty()) list.add(1) else list.add(0)
            "front" -> if (deque.isEmpty()) list.add(-1) else list.add(deque.first())
            "back" -> if (deque.isEmpty()) list.add(-1) else list.add(deque.last())
        }
    }
    println(list.joinToString("\n"))

}