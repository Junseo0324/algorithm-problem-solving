package programmers.practice04

fun solution87389(n: Int): Int {
    var answer: Int = 0
    for (i in 1..n) {
        if (n % i == 1) {
            answer = i
            break
        }
    }
    return answer
}