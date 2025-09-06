package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/68644?language=kotlin


fun solution68644(numbers: IntArray): IntArray {
    var answer = mutableListOf<Int>()
    for (i in 0 until numbers.size) {
        for (j in i until numbers.size) {
            var sum = numbers[i] + numbers[j]
            if (i != j) {
                if (!answer.contains(sum)) {
                    answer.add(sum)
                }
            }
        }
    }
    return answer.sorted().toIntArray()
}

fun main() {
    println(solution68644(intArrayOf(2,1,3,4,1)))
}