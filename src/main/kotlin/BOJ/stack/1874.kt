package BOJ.stack

// https://www.acmicpc.net/problem/1874

fun main() {
    val n = readln().toInt()
    val stack = mutableListOf<Int>()
    val list = mutableListOf<Int>()
    val answer = mutableListOf<String>()
    repeat(n) {
        list.add(readln().toInt())
    }
    var i = 1
    stack.add(i)
    answer.add("+")
    list.forEach {
        while (true) {
            if (stack.isNotEmpty()) {
                if (stack.last() == it) {
                    answer.add("-")
                    stack.removeLast()
                    break
                } else if (i <= n) {
                    answer.add("+")
                    i++
                    stack.add(i)

                } else {
                    break
                }
            } else {
                i++
                stack.add(i)
                answer.add("+")
            }
        }
    }

    if (stack.isEmpty()) {
        println(answer.joinToString("\n"))
    } else {
        println("NO")
    }


}