package programmers.level_2

import java.util.Stack
// https://school.programmers.co.kr/learn/courses/30/lessons/131704

//stack
fun solution131704(order: IntArray): Int {
    val stack = Stack<Int>()
    var answer = 0
    var box = 1
    for (i in order.indices) { // 순서대로 옴.
        while (true) {
            if (box > order.size+1) {
                break
            }
            if (stack.isNotEmpty()) {
                if (stack.peek() == order[i]) {
                    answer++
                    stack.pop()
                    break
                } else {
                    stack.push(box)
                    box++
                }
            } else {
                stack.push(box)
                box++

            }
        }
    }
    return answer

}

fun main() {
    println(solution131704(intArrayOf(4,3,1,2,5)))
}