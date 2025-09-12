package programmers.level_2

import java.util.Stack

// https://school.programmers.co.kr/learn/courses/30/lessons/76502

/**
 * s -> 왼쪽으로 x 만큼 회전시켰을 때 s 가 올바른 문자열이 되는 x의 개수
 */

fun solution76502(s: String): Int {
    var answer= 0
    var rotateStr = s

    for (i in rotateStr.indices) {
        if (isStackEmpty(rotateStr)) answer++
        rotateStr = rotateStr.substring(1) + rotateStr.first()
    }
    return answer
}

fun isStackEmpty(str: String): Boolean {
    var stack = Stack<Char>()
    for (c in str) {
        when(c) {
            '(','{','[' -> stack.add(c)
            ')' -> if(stack.isEmpty() || stack.removeAt(stack.size-1) !='(') {
                return false
            }
            '}' -> if(stack.isEmpty() || stack.removeAt(stack.size-1) !='{') {
                return false
            }
            ']' -> if(stack.isEmpty() || stack.removeAt(stack.size-1) !='[') {
                return false
            }
        }
    }
    return stack.isEmpty()
}



fun main() {
    println(solution76502("[](){}"))
}