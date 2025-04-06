package bfs

import java.util.LinkedList

/**
 * 시간 제한 : 2초
 * 시간 복잡도 : 1,000 + 10,000 = 11,000 * 10,000 = 110,000,000
 * 정점의 개수 N, 간선의 개수 M , 탐색을 진행할 정점의 번호 V
 * M개의 줄에는 간선을 연결하는 두 정점의 번호가 주어짐
 *
 */
fun main() {
    var (n,m,v) = readln().split(" ").map { it.toInt() }
    var answer = mutableListOf<Int>()
    var bfsAnswer = mutableListOf<Int>()
    var graph = Array(n+1) { mutableListOf<Int>() }
    var visited = BooleanArray(n+1)


    repeat(m) {
        var (start, depart) = readln().split(" ").map { it.toInt() }
        graph[start].add(depart)
        graph[depart].add(start)
    }

    for (i in graph.indices) {
        graph[i] = graph[i].sorted().toMutableList()
    }
    fun dfs(x: Int) {
        visited[x] = true
        answer.add(x)
        for (i in graph[x]) {
            if (!visited[i]) {
                dfs(i)
            }
        }
    }

    fun bfs(x: Int) {
        val queue = LinkedList<Int>()
        queue.offer(x)
        visited[x] = true

        while (queue.isNotEmpty()) {
            var curr = queue.poll()
            bfsAnswer.add(curr)
            for (i in graph[curr]) {
                if (!visited[i]){
                    visited[i] = true
                    queue.add(i)
                }
            }
        }
    }

    dfs(v)
    visited = BooleanArray(n+1){false}
    bfs(v)
    println(answer.joinToString(" "))
    println(bfsAnswer.joinToString(" "))
}