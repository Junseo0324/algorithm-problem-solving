package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/138476

fun solution138476(k: Int, tangerine: IntArray): Int {
    var sortedList = tangerine.groupBy { it }.entries.flatMap { listOf(it.value.size) }
    var sum = 0
    var answer= 0

    for (i in sortedList.sortedDescending()) {
        sum+=i
        answer +=1
        if (sum >=k) {
            break
        }
    }

    return answer
}

fun main() {
    println(solution138476(6, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)))
    println(solution138476(4, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)))
    println(solution138476(2, intArrayOf(1, 1, 1, 1, 2, 2, 2, 3)))
}

