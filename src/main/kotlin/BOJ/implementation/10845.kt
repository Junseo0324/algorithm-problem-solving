package BOJ.implementation

import java.util.LinkedList
import java.util.Queue

// https://www.acmicpc.net/problem/10845

fun main() = with(System.`in`.bufferedReader()){
    val queue: Queue<Int> = LinkedList()

    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val input = readln().split(" ")
        val action: String?
        var num= 0
        if (input.size == 1) action = input[0]
        else {
            action = input[0]
            num = input[1].toInt()
        }
        when (action) {
            "push" -> queue.add(num)
            "pop" -> sb.append(if (queue.isEmpty()) -1 else queue.poll()).append("\n")
            "size" -> sb.append(queue.size).append("\n")
            "empty" -> sb.append(if (queue.isEmpty()) 1 else 0).append("\n")
            "front" -> sb.append(if (queue.isNotEmpty()) queue.peek() else -1).append("\n")
            "back" -> sb.append(if (queue.isNotEmpty()) queue.last() else -1).append("\n")
        }
    }
    println(sb)
}