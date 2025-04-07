package BOJ.bfs

import java.util.LinkedList

/**
 * n x n 정사각형
 * 1 -> 있는 곳 / 0 -> 없는 곳
 */

fun main() {
    var n = readln().toInt()
    var array = Array(n) {IntArray(n)}
    var visited = Array(n) {BooleanArray(n+1) {false}}
    var dx = arrayOf(1,0,-1,0)
    var dy = arrayOf(0,1,0,-1)
    var answer = mutableListOf<Int>()
    repeat(n) {
        array[it] = readln().map { it.toString().toInt() }.toIntArray()
    }

    fun bfs(x:Int,y:Int): Int {
        var count = 1
        val queue = LinkedList<Pair<Int,Int>>()
        queue.offer(Pair(x,y))
        visited[x][y] = true

        while (queue.isNotEmpty()) {
            val curr = queue.poll()

            for (i in 0 until 4) {
                var nx = dx[i] + curr.first
                var ny = dy[i] + curr.second

                if (!(nx in 0 until n && ny in 0 until n)) continue
                if (!visited[nx][ny] && array[nx][ny] !=0) {
                    queue.offer(Pair(nx,ny))
                    visited[nx][ny] = true
                    count++
                }
            }
        }
        return count
    }

    for (i in 0 until n) {
        for (j in 0 until n){
            if (!visited[i][j] && array[i][j] == 1) {
                answer.add(bfs(i,j))

            }
        }
    }

    println(answer.size)
    println(answer.sorted().joinToString("\n"))



}