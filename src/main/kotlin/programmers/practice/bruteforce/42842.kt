package programmers.practice.bruteforce

fun main() {
    println(
        solution42842(brown = 10, yellow = 2)
    )
    println(
        solution42842(brown = 8, yellow = 1)
    )
    println(
        solution42842(brown = 24, yellow = 24)
    )
}

fun solution42842(brown: Int, yellow: Int): IntArray {
    var answer = intArrayOf()
    var carpet = brown + yellow
    for (i in 3..carpet) {
        if (carpet % i == 0) {
            var x = i
            var y = carpet

            if ((x - 2) * (y - 2) == yellow) {
                answer += y
                answer += x
                break
            }
        }
    }
    return answer
}