package BOJ.stack

// https://www.acmicpc.net/problem/2493

fun main() {
    readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val stack = mutableListOf<Pair<Int,Int>>()
    val answer = mutableListOf<Int>()

    list.forEachIndexed{ idx,it ->
        while (true) {
            if (stack.isNotEmpty()) {
                if (stack.last().second > it) {
                    answer.add(stack.last().first)
                    stack.add(Pair(idx+1,it))
                    break
                } else {
                    stack.removeLast()
                }
            } else {
                answer.add(0)
                stack.add(Pair(idx+1,it))
                break
            }
        }
    }
    println(answer.joinToString(" "))
}