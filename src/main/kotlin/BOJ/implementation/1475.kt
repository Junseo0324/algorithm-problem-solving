package BOJ.implementation

// https://www.acmicpc.net/problem/1475

fun main() {
    val n = readln()
    val count = IntArray(10)
    for (c in n) {
        val num = c.digitToInt()
        if (num == 6 || num == 9) count[6]++
        else count[num]++
    }

    count[6] = (count[6] + 1) / 2
    println(count.max())
}