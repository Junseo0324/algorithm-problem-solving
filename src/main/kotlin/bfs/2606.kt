package bfs

import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val array = Array(n+1) { ArrayList<Int>()}
    var visited = BooleanArray(n+1) { false }
    var answer = 0
    repeat(m) {
        val (start,end) = readln().split(" ").map { it.toInt() }
        array[start].add(end)
        array[end].add(start)
    }

    fun bfs(x: Int) {
        val queue = LinkedList<Int>()
        queue.add(x)
        visited[x] = true

        while (queue.isNotEmpty()) {
            var curr = queue.poll()

            for (i in array[curr]) {
                if (!visited[i]) {
                    visited[i] = true
                    answer++
                    queue.offer(i)
                }
            }
        }
    }

    bfs(1)

    println(answer)




}