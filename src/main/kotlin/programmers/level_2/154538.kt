package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/154538

import java.util.LinkedList
import java.util.Queue

fun solution154538(x: Int, y: Int, n: Int): Int {
    var answer = mutableListOf<Int>()
    val visited = hashMapOf<Int,Boolean>()

    fun bfs(count: Int) {
        val queue: Queue<Pair<Int,Int>> = LinkedList()
        queue.add(Pair(x,count))

        while (queue.isNotEmpty()) {
            val curr = queue.poll()

            if (curr.first > y) continue
            if (curr.first == y) {
                answer.add(curr.second)
                break
            }
            if(visited[curr.first + n] != true) {
                queue.add(Pair(curr.first + n,curr.second + 1))
                visited[curr.first + n] = true
            }
            if(visited[curr.first * 2] != true) {
                queue.add(Pair(curr.first * 2,curr.second + 1))
                visited[curr.first * 2] = true
            }
            if(visited[curr.first * 3] != true) {
                queue.add(Pair(curr.first * 3,curr.second + 1))
                visited[curr.first * 3] = true
            }
        }
    }
    bfs(0)
    if(answer.isEmpty()) {
        return -1
    } else {
        return answer.first()
    }
}

fun main() {
    println(solution154538(10,40,5))
}