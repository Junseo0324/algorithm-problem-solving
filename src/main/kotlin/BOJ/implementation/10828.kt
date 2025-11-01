package BOJ.implementation

import java.util.Stack

fun main() = with(System.`in`.bufferedReader()){
    val s = Stack<Int>()
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val input = readLine().split(" ")
        val action = input[0]
        val num = if (input.size > 1) input[1].toInt() else 0
        when(action) {
            "push" -> s.add(num)
            "pop" -> sb.append(if (s.isNotEmpty()) s.pop() else -1).append('\n')
            "size" -> sb.append(s.size).append('\n')
            "empty" -> sb.append(if (s.isEmpty()) 1 else 0).append('\n')
            "top" -> sb.append(if (s.isNotEmpty()) s.peek() else -1).append('\n')
        }
    }
    print(sb)
}