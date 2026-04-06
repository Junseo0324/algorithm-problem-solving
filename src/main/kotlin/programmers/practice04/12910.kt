package programmers.practice04

fun solution(arr: IntArray, divisor: Int): IntArray {
    var answer = intArrayOf()
    for (num in arr) {
        if (num % divisor == 0) {
            answer += num
        }
    }
    answer.sort()
    return if (answer.size > 0) answer else intArrayOf(-1)
}