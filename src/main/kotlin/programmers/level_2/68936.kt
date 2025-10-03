package programmers.level_2

//https://school.programmers.co.kr/learn/courses/30/lessons/68936

fun solution68936(arr: Array<IntArray>): IntArray {
    val answer = IntArray(2)

    fun compress(x: Int, y: Int, size: Int) {
        val first = arr[x][y]
        var same = true
        loop@ for (i in x until x + size) {
            for (j in y until y + size) {
                if (arr[i][j] != first) {
                    same = false
                    break@loop
                }
            }
        }

        if (same) {
            answer[first]++
            return
        }

        val half = size / 2
        compress(x, y, half)
        compress(x, y + half, half)
        compress(x + half, y, half)
        compress(x + half, y + half, half)
    }

    compress(0, 0, arr.size)
    return answer
}

fun main() {
    println(solution68936(arrayOf(
        intArrayOf(1,1,0,0),
        intArrayOf(1,0,0,0),
        intArrayOf(1,0,0,1),
        intArrayOf(1,1,1,1)
    )).toList())
}

