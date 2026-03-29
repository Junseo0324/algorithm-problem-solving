package programmers.practice.bruteforce

fun main() {
    println(
        solution42840(
            answers = intArrayOf(1,2,3,4,5)
        )
    )
    println(
        solution42840(
            answers = intArrayOf(1,3,2,4,2)
        )
    )
}

fun solution42840(answers: IntArray): IntArray {
    var answer = intArrayOf()
    val one = intArrayOf(1, 2, 3, 4, 5)
    val two = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val three = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    val list = mutableListOf(0, 0, 0)
    for (i in answers.indices) {
        if (answers[i] == one[i % one.size]) {
            list[0] += 1
        }
        if (answers[i] == two[i % two.size]) {
            list[1] += 1
        }
        if (answers[i] == three[i % three.size]) {
            list[2] += 1
        }
    }

    val max = list.maxOrNull()!!

    for (i in list.indices) {
        if (list[i] == max) {
            answer += i+1
        }
    }
    return answer
}