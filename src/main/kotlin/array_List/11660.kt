package array_List

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val array = Array(n) { IntArray(n) }
    var answer = 0
    repeat(n) {
        var input = readln().split(" ").map { it.toInt() }
        array[it] = input.toIntArray()
    }
    val sumArr = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n) {
        for (j in 1..n) {
            sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + array[i - 1][j - 1]
        }
    }

    repeat(m) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
        answer = sumArr[x2][y2] - sumArr[x1-1][y2] - sumArr[x2][y1-1] + sumArr[x1-1][y1-1]
        println(answer)
    }


}