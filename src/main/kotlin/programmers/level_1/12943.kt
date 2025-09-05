package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12943


fun solution12943(num: Int): Int {
    var answer = 0
    var n = num
    while (true) {
        if (answer >= 500) {
            return -1
        }
        if (n == 1) {
            return answer
        }
        if (n % 2 == 0) {
            n /= 2
        } else if (n % 2 ==1){
            n = (n * 3) + 1
        }
        answer++
    }
    return answer
}

fun main() {
    println(solution12943(626331))
}
