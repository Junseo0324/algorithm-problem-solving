package BOJ.implementation

// https://www.acmicpc.net/problem/2847

fun main() {
    val n = readln().toInt()
    val array = IntArray(n)
    var answer = 0
    repeat(n) {
        array[it] = readln().toInt()
    }

    for (i in n - 2 downTo 0) {
        if (array[i] >= array[i + 1]) {
            val score = array[i + 1] - 1
            val count = array[i] - score

            answer += count

            array[i] = score
        }
    }

    println(answer)

}