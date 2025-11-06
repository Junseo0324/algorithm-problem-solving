package BOJ.stack

// https://www.acmicpc.net/problem/2504

fun main() {
    val list = readln().toList()
    val stack = mutableListOf<Char>()
    var answer = 0
    var temp = 1

    for (i in list.indices) {
        when (list[i]) {
            '(' -> {
                temp *= 2
                stack.add(list[i])
            }

            '[' -> {
                temp *= 3
                stack.add(list[i])
            }

            ')' -> {
                if (stack.isEmpty() || stack.last() != '(') {
                    answer = 0
                    break
                }
                if (list[i - 1] == '(') {
                    answer += temp
                }
                stack.removeLast()
                temp /= 2
            }

            ']' -> {
                if (stack.isEmpty() || stack.last() != '[') {
                    answer = 0
                    break
                }
                if (list[i - 1] == '[') {
                    answer += temp

                }
                stack.removeLast()
                temp /= 3
            }
        }
    }
    if (stack.isNotEmpty()) answer = 0

    println(answer)

}