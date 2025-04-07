package BOJ.stack_queue

import java.util.LinkedList
import java.util.Queue

fun main() {
    var n = readln().toInt()
    var queue: Queue<Int> = LinkedList((1..n).toList())
    var answer = 0
    while (queue.isNotEmpty()){
        if (queue.size ==1) {
            answer = queue.poll()
            break
        }
        queue.poll()
        var curr = queue.poll()
        queue.add(curr)
    }
    println(answer)
}