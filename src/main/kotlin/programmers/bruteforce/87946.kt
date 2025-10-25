package programmers.bruteforce

// https://school.programmers.co.kr/learn/courses/30/lessons/87946?language=kotlin

fun solution87946(k: Int, dungeons: Array<IntArray>): Int {
    var answer = 0
    val list = permutations(dungeons.indices.toList())
    list.forEach { data ->
        var remain = k
        var count = 0
        for (idx in data) {
            if (dungeons[idx][0] <= remain) {
                count++
                remain -= dungeons[idx][1]
            } else {
                break
            }
        }
        answer = Math.max(answer,count)

    }
    return answer
}

fun <T> permutations(list: List<T>): List<List<T>> {
    val result = mutableListOf<List<T>>()
    val visited = BooleanArray(list.size)

    fun dfs(path: MutableList<T>) {
        if (path.size == list.size) {
            result.add(path.toList())
            return
        }

        for (i in list.indices) {
            if (!visited[i]) {
                visited[i] = true
                path.add(list[i])
                dfs(path)
                path.removeAt(path.lastIndex)
                visited[i] = false
            }
        }
    }

    dfs(mutableListOf())
    return result
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