package programmers.practice04.level1

fun main() {
    println(solution42840(intArrayOf(1,2,3,4,5)))
}

fun solution42840(answers: IntArray): IntArray {
    var answer = intArrayOf()
    val one = intArrayOf(1, 2, 3, 4, 5)
    val two = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val three = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
    var oneCount = 0
    var twoCount = 0
    var threeCount = 0
    for (i in answers.indices) {
        if (answers[i] == one[i % one.size]) {
            oneCount++
        }
        if (answers[i] == two[i % two.size]) {
            twoCount++
        }
        if (answers[i] == three[i % three.size]) {
            threeCount++
        }
    }
    answer += oneCount
    answer += twoCount
    answer += threeCount
    return answer
}