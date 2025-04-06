package stack_queue

import java.util.Stack

fun main() {
    var n = readln().toInt()
    var stack = Stack<Int>()
    var count = 0


    repeat(n) {
        var input = readln().toInt()
        while (stack.isNotEmpty() && stack.peek() <= input) {
            stack.pop()
        }
        count += stack.size
        stack.push(input)

    }
    /**
     input = 10
        count = 0
            stack.size = 0
        stack = 10

     input = 3
        count = 1
            stack.size = 1
        stack = 10,3

     input = 7
        stack = 10
        count = 2
            stack = 10,7

     input = 4
        stack = 10,7
        count = 4
        stack = 10,7,4
     input = 12
        stack =
        count = 4
        stack = 12

     input = 2
        stack = 12
        count = 5
        stack =12,2

     */


    println(count)
}