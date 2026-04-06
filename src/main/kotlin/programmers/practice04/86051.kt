package programmers.practice04

fun main() {
    fun solution86051(numbers: IntArray): Int {
        var answer: Int = 0
        for (i in 0..9) {
            if (i !in numbers) {
                answer += i
            }
        }
        return answer
    }
}