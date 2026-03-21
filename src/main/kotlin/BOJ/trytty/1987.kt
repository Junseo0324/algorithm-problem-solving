package BOJ.trytty

fun main() {

    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)

    val (r, c) = readln().split(" ").map { it.toInt() }
    val graph = Array(r) { readln().toCharArray() }

    val visited = BooleanArray(26)

    var max = 0

    fun dfs(x: Int, y: Int, count: Int) {
        max = maxOf(max, count)

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until r && ny in 0 until c) {
                val next = graph[nx][ny]
                var charIndex = next - 'A'

                if (!visited[charIndex]) {
                    visited[charIndex] = true

                    dfs(nx,ny,count+1)

                    visited[charIndex] = false
                }
            }
        }
    }

    visited[graph[0][0]-'A'] = true
    dfs(0,0,1)

    println(max)
}