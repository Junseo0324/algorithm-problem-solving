package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/77484?language=kotlin
/**
 * answer = 6 -> 1
 * answer = 5 ->2
 * 4->3
 * 3->4
 * 2 ->5
 * 6-2+1
 */
fun solution77484(lottos: IntArray, win_nums: IntArray): IntArray {
    var answer: IntArray = intArrayOf()
    var correctList = mutableListOf<Int>()
    var zero = lottos.count { it == 0 }
    win_nums.sorted().forEach {
        if (lottos.contains(it)) {
            correctList.add(it)
        }
    }

    if (correctList.size == 0 && zero == 0) {
        answer += 6
        answer += 6
    } else if (correctList.size == 0) {
        answer += 6 - zero + 1
        answer += 6
    } else if (zero == 0) {
        answer += 6 - correctList.size + 1
        answer += 6 - correctList.size + 1
    } else {
        answer += 6 - (correctList.size + zero) + 1
        answer += 6 - correctList.size + 1
    }
    println(answer.joinToString(","))
    return answer
}

fun main() {
    println(solution77484(intArrayOf(44, 1, 0, 0, 31, 25), intArrayOf(31, 10, 45, 1, 6, 19)))
    println(solution77484(intArrayOf(0, 0, 0, 0, 0, 0), intArrayOf(38, 19, 20, 40, 15, 25)))
    println(solution77484(intArrayOf(45, 4, 35, 20, 3, 9), intArrayOf(20, 9, 3, 45, 4, 35)))
    println(solution77484(intArrayOf(1, 2, 3, 4, 5, 6), intArrayOf(7, 8, 9, 10, 11, 12)))
}