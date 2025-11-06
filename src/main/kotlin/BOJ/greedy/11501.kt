package BOJ.greedy

// https://www.acmicpc.net/problem/11501

fun main() {
    repeat(readln().toInt()) {
        readln().toInt()
        var list = readln().split(" ").map { it.toLong() }
        var maxPrice = 0L
        var answer = 0L
        list = list.reversed()
        for (i in list.indices) {
            if (list[i] > maxPrice) {
                maxPrice = list[i]
            } else if (list[i] < maxPrice) {
                answer += (maxPrice-list[i])
            }
        }

        println(answer)
    }
}