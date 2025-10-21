package BOJ.stack

// https://www.acmicpc.net/problem/17298

/**
 * n < 10^6
 * 오큰수 : 오른쪽에 있으면서 Ai보다 큰 수 중 가장 왼쪽에 있는 수.
 * [3,5,2,7]  -> [5,7,7,-1]
 * [7,2,5,3] 왼쪽에 있으면서 Ai보다 작은 수 발견시?
 * stack[7]  // it = 2
 * stack [7,2] // it = 5 -> stack = 7 , it = 5
 * stack [7] // it = 3
 *
 * [9 5 4 8 ] -1 8 8 -1
 * [8 4 5 9]  -1 8 8
 */
fun main() {
    readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.reversed()
    val stack = mutableListOf<Int>()
    val answer = mutableListOf<Int>()
    stack.add(list[0])
    answer.add(-1)
    for (i in 1 until list.size) {
        while (true) {
            if (stack.isNotEmpty()) {
                if (list[i] < stack.last()) {
                    answer.add(stack.last())
                    stack.add(list[i])
                    break
                } else {
                    stack.removeLast()
                }
            } else {
                answer.add(-1)
                stack.add(list[i])
                break
            }
        }
    }

    println(answer.reversed().joinToString(" "))
}