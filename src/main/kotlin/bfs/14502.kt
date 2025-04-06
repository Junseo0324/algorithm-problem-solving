package bfs

import java.util.LinkedList

/**
 * n x m
 * 벽(1)은 3개 세워야한다.
 * 바이러스(2)는 0으로 퍼짐
 * 벽을 3개 세운 뒤 안전 영역의 최댓값을 구해야한다.
 *
 *
 * bfs() 를 실행한 후 안전 영역의 값(0)의 개수를 세어 변수에 저장 ( 항상 최댓값 유지 )
 * 벽 3개를 어덯게 세울것인가. 백트래킹?
 */
fun main() {
    var (n,m) = readln().split(" ").map { it.toInt() }
    var array = Array(n) { IntArray(m)}
    var copyArray = Array(n) { IntArray(m)}
    var visited = Array(n) { BooleanArray(m+1)}
    var dx = arrayOf(1,0,-1,0)
    var dy = arrayOf(0,1,0,-1)

    var answer = 0

    repeat(n) {
        array[it] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    fun bfs() {
        var queue = LinkedList<Pair<Int,Int>>()
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (copyArray[i][j] ==2) {
                    queue.offer(Pair(i,j))
                    visited[i][j]=true
                }
            }
        }

        while (queue.isNotEmpty()) {
            var curr = queue.poll()
            for (i in 0 until 4){
                var nx = curr.first + dx[i]
                var ny = curr.second + dy[i]

                if (!(nx in 0 until n && ny in 0 until m)) continue

                if (copyArray[nx][ny] !=0) {
                    continue
                }
                copyArray[nx][ny] = 2
                visited[nx][ny] = true
                queue.offer(Pair(nx,ny))
            }
        }

        var count = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (copyArray[i][j] == 0) {
                    count++
                }
            }
        }
        if (count > answer) {
            answer = count
        }


    }

    fun wall(depth: Int) {
        if (depth == 3) {
            for (i in 0 until n) {
                for (j in 0 until m) {
                    visited[i][j] = false
                    copyArray[i][j] = array[i][j]
                }
            }
            bfs()
            return
        }

        for (i in 0 until n){
            for (j in 0 until m){
                if (array[i][j]==0) {
                    array[i][j] =1
                    wall(depth+1)
                    array[i][j]=0
                }
            }
        }
    }

    wall(0)
    println(answer)

}
