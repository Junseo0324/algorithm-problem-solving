package programmers.practice.bruteforce

fun main() {
    println(
        solution87946(
            k = 80,
            dungeons = arrayOf(
                intArrayOf(80, 20),
                intArrayOf(50, 40),
                intArrayOf(30, 10),
            )
        )
    )
}

fun solution87946(k: Int, dungeons: Array<IntArray>): Int {
    var answer: Int = -1
    val size = dungeons.size
    val list = permutationDungeon((0 until size).toList())
    var tired = k
    for (dungeon in list) {
        tired = k
        var count = 0
        for (data in dungeon) {
            if (tired >= dungeons[data][0]) {
                tired -= dungeons[data][1]
                count++
            } else {
                break
            }
        }
        answer = maxOf(count, answer)
    }

    return answer
}


fun permutationDungeon(list: List<Int>): MutableList<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val visited = BooleanArray(list.size)

    fun backtrack(current: MutableList<Int>) {
        if (current.size == list.size) {
            result.add(current.toList())
            return
        }

        for (i in list.indices) {
            if (!visited[i]) {
                visited[i] = true
                current.add(list[i])

                backtrack(current)
                current.removeLast()
                visited[i] = false
            }
        }
    }

    backtrack(mutableListOf())
    return result
}