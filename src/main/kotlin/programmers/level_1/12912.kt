package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12912?language=kotlin


fun solution12912(a: Int, b: Int): Long {
    var answer: Long = 0
    if (a > b) {
        for(i in b..a) {
            answer += i
        }
    } else if (a < b) {
        for(i in a..b) {
            answer += i
        }
    } else {
        return a.toLong()
    }
    return answer
}


fun main() {
    println(solution12912(3,3))
}