package BOJ.graph

// https://www.acmicpc.net/problem/2667

/**
 *  0 => 집이 없는 곳
 *  1 => 집이 있는 곳
 *
 */

fun main() {
    val n = readln().toInt()
    val graph = Array(n) {IntArray(n) }
    val visited = Array(n) {BooleanArray(n+1)}
    val dx = listOf(1,0,-1,0)
    val dy = listOf(0,1,0,-1)
    val answer = mutableListOf<Int>()

    repeat(n) {
        graph[it] = readln().map { it.digitToInt() }.toIntArray()
    }

    fun bfs(x:Int, y: Int) {
        var count = 1
        val queue = ArrayDeque<Pair<Int,Int>>()
        queue.addLast(Pair(x,y))
        visited[x][y] = true


        while (queue.isNotEmpty()) {
            val curr = queue.removeLast()

            for (i in 0 until 4) {
                val nx = dx[i] + curr.first
                val ny = dy[i] + curr.second

                if (!(nx in 0 until n && ny in 0 until n)) continue
                if (!visited[nx][ny] && graph[nx][ny] !=0) {
                    queue.addLast(Pair(nx,ny))
                    visited[nx][ny] = true
                    count++
                }
            }
        }
        answer.add(count)
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j] && graph[i][j]==1) {
                bfs(i,j)
            }
        }
    }

    println(answer.size)
    println(answer.sorted().joinToString("\n"))

}