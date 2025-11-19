package BOJ.graph

// https://www.acmicpc.net/problem/14503

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var (x, y, d) = readln().split(" ").map { it.toInt() }
    val array = Array(n) { IntArray(m) }
    repeat(n) {
        array[it] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    val dx = listOf(-1, 0, 1, 0)
    val dy = listOf(0, 1, 0, -1)

    var cleanCount = 0

    while (true) {
        if (array[x][y] == 0) {
            array[x][y] = 2
            cleanCount++
        }

        var hasDirty = false

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until n && ny in 0 until m && array[nx][ny] == 0) {
                hasDirty = true
                break
            }
        }

        if (hasDirty) {
            d = (d + 3) % 4
            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx in 0 until n && ny in 0 until m && array[nx][ny] == 0) {
                x = nx
                y = ny
            }
        } else {
            val backX = x - dx[d]
            val backY = y - dy[d]

            if (backX !in 0 until  n || backY !in 0 until m || array[backX][backY] == 1) {
                break
            } else {
                x = backX
                y = backY
            }
        }
    }
    println(cleanCount)
}