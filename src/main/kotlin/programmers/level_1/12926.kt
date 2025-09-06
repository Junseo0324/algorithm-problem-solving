package programmers.level_1


// https://school.programmers.co.kr/learn/courses/30/lessons/12926

fun solution12926(s: String, n: Int): String {
    var answer = ""
    for (c in s) {
        if (c != ' ') {
            if (c.isUpperCase()) {
                if (c + n > 90.toChar()) {
                    answer += c -26 + n
                } else {
                    answer += c + n
                }
            } else {
                if (c+n > 122.toChar()) {
                    answer += c - 26 + n
                } else {
                    answer += c+n
                }
            }
        } else {
            answer += ' '
        }
    }
    return answer
}

fun main() {
    println(solution12926("AB",1))
}