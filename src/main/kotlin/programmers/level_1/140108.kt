package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/140108?language=kotlin

fun solution140108(s: String): Int {
    var answer = 0
    var str = s
    while (str.isNotEmpty()) {
        var x_count = 1
        var not_x = 0
        for (i in 1 until str.length) {
            if (str.elementAt(0) == str.elementAt(i)) x_count++ else not_x++
            if (x_count == not_x) break
        }
        str = str.substring(x_count+not_x)
        println(str)
        answer++
    }

    return answer
}

fun main() {
    println(solution140108("banana"))
    println(solution140108("abracadabra"))
    println(solution140108("aaabbaccccabba"))
}