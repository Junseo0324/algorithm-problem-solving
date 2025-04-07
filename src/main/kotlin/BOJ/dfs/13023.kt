package BOJ.dfs

/**
 * N명이 참가
        0 ~ N-1 번으로 번호
        일부 사람 -> 친구
 * ex)
        a - b 친구
        b - c 친구
        c - d 친구
        d - e 친구
        a,b,c,d,e가 친구관계 즉 depth 5인 친구 관계가 존재하는가에 대한 문제
 */

fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }
    var graph = Array(n+1) { mutableListOf<Int>() }
    var visited = BooleanArray(n+1)
    var answer = false
    repeat(m) {
        val (start,end) = readln().split(" ").map { it.toInt() }
        graph[start].add(end)
        graph[end].add(start)
    }

    fun dfs(x:Int, depth: Int){
        if (depth == 5) {
            answer = true
            return
        }
        visited[x] = true
        for (i in graph[x]) {
            if (!visited[i]) {
                dfs(i, depth + 1)
            }
        }
        visited[x] = false
    }

    for (i in 1..n) {
        dfs(i,1)
        if (answer) {
            break
        }
    }
    if (answer) {
        println(1)
    } else println(0)


}