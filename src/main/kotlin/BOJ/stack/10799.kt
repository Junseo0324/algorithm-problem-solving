package BOJ.stack

import java.util.Stack

// https://www.acmicpc.net/problem/10799

fun main() {
    val list = readln().toList()
    val stack = Stack<Char>()
    var answer = 0
    for (i in list.indices) {
        if (list[i] == '(') {
            stack.push(list[i])
        } else {
            stack.pop()
            answer += if (list[i-1] == '(') stack.size else 1
        }
    }
    println(answer)

}