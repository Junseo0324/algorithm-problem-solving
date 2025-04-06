package stack_queue

import java.util.Stack

fun main() {
    var n = readln().toInt()
    var stack = Stack<Int>()
    var list = mutableListOf<Int>()
    var answerList = mutableListOf<String>()

    repeat(n) {
        list.add(readln().toInt())
    }
    var number = 1
    for (i in 0 until list.size) {
        while (true) {
            if (number > list.size+1) {
                break
            }
            if (stack.isNotEmpty()) {
                if (stack.peek() == list[i]) {
                    stack.pop()
                    answerList.add("-")
                    break
                } else {
                    stack.push(number)
                    number++
                    answerList.add("+")
                }
            } else {
                stack.push(number)
                number++
                answerList.add("+")
            }
        }
    }
    if (number == list.size+1) {
        println(answerList.joinToString("\n"))
    } else {
        println("NO")
    }
}