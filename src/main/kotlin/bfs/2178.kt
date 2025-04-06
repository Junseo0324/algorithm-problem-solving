package bfs

import java.util.LinkedList

fun main() {
    var (n,m) = readln().split(" ").map { it.toInt() }
    var array = Array(n) { IntArray(m)}
    var dx = arrayOf(1,0,-1,0)
    var dy = arrayOf(0,1,0,-1)
    var visited = Array(n) { BooleanArray(m)}

    repeat(n) { index ->
        array[index] = readln().map { it.toString().toInt() }.toIntArray()
    }

    fun bfs(x:Int, y:Int) {
        var queue = LinkedList<Pair<Int,Int>>()
        queue.offer(Pair(x,y))
        visited[x][y] = true

        while (queue.isNotEmpty()) {
            var curr = queue.poll()

            for (i in 0 until 4) {
                var nx = dx[i] + curr.first
                var ny = dy[i] + curr.second


                if (!(nx in 0 until n && ny in 0 until m)) {
                    continue
                }

                if (!visited[nx][ny] && array[nx][ny]!=0) {
                    queue.offer(Pair(nx,ny))
                    array[nx][ny] = array[curr.first][curr.second]+1
                    visited[nx][ny] = true
                }
            }
        }
    }


    bfs(0,0)
    array.forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }
    println(array[n-1][m-1])


}