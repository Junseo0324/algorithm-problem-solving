package programmers.practice04.level1

fun solution12926(s: String, n: Int): String {
    var answer = ""
    s.forEach {
        var c = ' '
        if (it != ' ') {
            if (it.isUpperCase()) {
                c = it + n
                if (c > 90.toChar()) {
                    answer += it - 26 + n
                } else {
                    answer += c
                }
            } else {
                c = it + n
                if (c > 122.toChar()) {
                    answer += it - 26 + n
                } else {
                    answer += c
                }
            }
        } else {
            answer += c
        }
    }
    return answer
}