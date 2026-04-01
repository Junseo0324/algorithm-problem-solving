package programmers.practice.dfs_bfs

fun main() {
    println(
        solution43162(
            n = 3, computers = arrayOf(
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 1, 1),
            )
        )
    )
    println(
        solution43162(
            n = 3, computers = arrayOf(
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 1),
                intArrayOf(0, 1, 1),
            )
        )
    )
}

fun solution43162(n: Int, computers: Array<IntArray>): Int {
    var answer = 0
    val visited = BooleanArray(n)

    fun dfs(start: Int) {
        visited[start] = true
        for (i in computers[start].indices) {
            if (computers[start][i] == 1 && !visited[i]) {
                dfs(i)
            }
        }
    }

    for (i in 0 until n) {
        if (!visited[i]) {
            dfs(i)
            answer++
        }
    }
    return answer
}