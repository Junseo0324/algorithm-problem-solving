package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/42842?language=kotlin

/**
 * brown , yellow
 * 8<brown<5000
 * 1<yellow<2,000,000
 * 가로 >= 세로 sortDescending()
 */
fun solution42842(brown: Int, yellow: Int): IntArray {
    var answer = intArrayOf()
    var carpet = brown + yellow

    for (i in 3..carpet) {
        if (carpet % i ==0) {
            var x = i
            var y = carpet / i
            if ((x-2) * (y-2) == yellow) {
                answer += y
                answer += x
                break
            }
        }
    }
    return answer
}

fun main() {
    println(solution42842(24,24))
}