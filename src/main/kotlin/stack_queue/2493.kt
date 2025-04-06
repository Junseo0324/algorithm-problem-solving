package stack_queue

import java.util.Stack

fun main() {
    var n = readln().toInt()
    var array = readln().split(" ").map { it.toInt() }
    var answerList = mutableListOf<Int>()

    var stack = Stack<Int>()

    //6 9 5 7 4
    answerList.add(0)
    stack.add(0)

    for (i in 1 until array.size) {
        while (true) {
            if (stack.isEmpty()) {
                stack.push(i)
                answerList.add(0)
                break
            } else {
                var curr = stack.peek()
                if (array[curr] >= array[i]){
                    answerList.add(curr+1)
                    stack.push(i)
                    break
                } else {
                    stack.pop()
                }
            }
        }
    }

    println(answerList.joinToString(" "))
}