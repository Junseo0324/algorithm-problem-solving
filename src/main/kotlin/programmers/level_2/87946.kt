package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/87946?language=kotlin
/**
 *
 * k(현재 피로도) = 1<k<5000
 * dungeons -> 1~8
 *
 * 8! = 1x2x3x4x5x6x7x8 = 720 x 7 5040 x 8 = 4xx00
 */
fun solution87946(k: Int, dungeons: Array<IntArray>): Int {
    var visited = BooleanArray(8)
    var count = 0
    var answer= 0

    fun dfs(k: Int, current: Int, dungeons: Array<IntArray>) {
        visited[current] = true
        count++

        if (answer < count) {
            answer = count
        }

        for (i in dungeons.indices) {
            val new = k - dungeons[current][1]
            if (!visited[i] && (dungeons[i][0]<=new)) {
                dfs(new,i,dungeons)
            }
        }

        visited[current] = false
        count--
    }

    for (i in dungeons.indices) {
        dfs(k,i,dungeons)
    }
    return answer
}

fun main() {
    println(solution87946(
        80,
        arrayOf(
            intArrayOf(80,20),
            intArrayOf(50,40),
            intArrayOf(30,10)
        )
    ))
}