package programmers.practice04.level1

fun main() {
    println(solution77484(lottos = intArrayOf(44, 1, 0, 0, 31, 25), win_nums = intArrayOf(31, 10, 45, 1, 6, 19)))
    println(solution77484(lottos = intArrayOf(0, 0, 0, 0, 0, 0), win_nums = intArrayOf(38, 19, 20, 40, 15, 25)))
    println(solution77484(lottos = intArrayOf(45, 4, 35, 20, 3, 9), win_nums = intArrayOf(20, 9, 3, 45, 4, 35)))
}

fun solution77484(lottos: IntArray, win_nums: IntArray): IntArray {
    var answer: IntArray = intArrayOf()
    var correctCount = 0
    val zeroCount = lottos.count { it == 0 }
    for (lotto in lottos) {
        if (lotto in win_nums) {
            correctCount++
        }
    }

    fun rank(num: Int): Int {
        return when(num) {
            2 -> 5
            3 -> 4
            4 -> 3
            5 -> 2
            6 -> 1
            else -> 6
        }
    }
    answer += rank(correctCount + zeroCount)
    answer += rank(correctCount)
    return answer
}