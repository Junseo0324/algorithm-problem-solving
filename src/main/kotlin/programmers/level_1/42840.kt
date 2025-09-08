package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/42840

fun solution42840(answers: IntArray): IntArray {
    var answer = intArrayOf()
    val one = listOf(1, 2, 3, 4, 5)
    val two = listOf(2, 1, 2, 3, 2, 4, 2, 5)
    val three = listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    val score = IntArray(3)
    for (i in answers.indices) {
        if (one[i % one.size] == answers[i]) {
            score[0]++
        }
        if (two[i % two.size] == answers[i]) {
            score[1]++
        }
        if (three[i % three.size] == answers[i]) {
            score[2]++
        }
    }

    for (i in score.indices) {
        if (score[i] == score.maxOrNull()) {
            answer += i + 1
        }
    }

    return answer.sortedArray()
}


fun main() {
    println(solution42840(intArrayOf(1,3,2,4,2)))
}