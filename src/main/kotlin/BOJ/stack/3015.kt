package BOJ.stack

// https://www.acmicpc.net/problem/3015

/**
 * 1<n<10^5
 */
fun main() {
    val n = readln().toInt()
    val stack = mutableListOf<Pair<Int,Int>>()
    var answer = 0L

    repeat(n) {
        val curr = readln().toInt()
        var count = 1
        while (stack.isNotEmpty() && stack.last().first <= curr) {
            val (topHeight, topCount) = stack.removeLast()
            answer += topCount
            if (topHeight == curr) {
                count += topCount
            }
        }

        if (stack.isNotEmpty()) {
            answer+=1L
        }

        stack.add(Pair(curr,count))
    }
    println(answer)
}