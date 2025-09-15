package programmers.level_2

import java.util.Stack

// https://school.programmers.co.kr/learn/courses/30/lessons/154539

/**
 * 배열의 각 원소에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수
 * 모든 원소에 대한 뒷큰수를 차례로 담은 배열을 return
 * 단 뒷 큰수가 존재하지 않는 경우 -1을 담음.
 *  -> 마지막 수는 무조건 -1? list.add(-1)
 */
fun solution154539(numbers: IntArray): IntArray {
    val stack = Stack<Int>()
    val list = mutableListOf<Int>()
    val reNumbers = numbers.reversed()

    stack.push(reNumbers[0])
    list.add(-1)

    for (i in 1 until reNumbers.size) {
        while (true) {
            if (stack.isEmpty()) {
                stack.push(reNumbers[i])
                list.add(-1)
                break
            } else {
                var curr = stack.peek()
                if (curr <= reNumbers[i]) {
                    stack.pop()
                } else {
                    list.add(curr)
                    stack.push(reNumbers[i])
                    break
                }
            }
        }
    }

    return list.reversed().toIntArray()
}

fun main() {
    println(solution154539(intArrayOf(2, 3, 3, 5)))          // [3, 5, 5, -1]
    println(solution154539(intArrayOf(9, 1, 5, 3, 6, 2))) // [-1, 5, 6, 6, -1, -1]
}

