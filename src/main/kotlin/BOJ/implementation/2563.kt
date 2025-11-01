package BOJ.implementation

// https://www.acmicpc.net/problem/2563

fun main() {
    val array = Array(100) { BooleanArray(100) }

    repeat(readln().toInt()) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        for (i in x until x + 10) {
            for (j in y until y + 10) {
                array[i][j] = true
            }
        }
    }

    println(array.flatMap { it.toList() }.count { it })

}