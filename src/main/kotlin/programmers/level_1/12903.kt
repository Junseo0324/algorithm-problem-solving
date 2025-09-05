package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12903?language=kotlin

fun solution12903(s: String): String {
    return if (s.length % 2 ==0) {
        return s.substring(s.length/2-1, s.length/2+1)
    } else {
        return s.substring(s.length/2,s.length/2+1)
    }
}

fun main() {
    println(solution12903("qwer"))
}