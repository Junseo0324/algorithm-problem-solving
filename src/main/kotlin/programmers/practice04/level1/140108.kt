package programmers.practice04.level1

fun main() {
    println(solution140108("banana")) // 3
    println(solution140108("abracadabra")) // 6
}

fun solution140108(s: String): Int {
    val answer = mutableListOf<String>()
    var x = ' '
    var idx = 0
    var xCount = 0
    var notXCount = 0
    for (i in s.indices) {
        if (x == ' ') {
            x = s[i]
            idx = i
        }
        if (s[i] == x) {
            xCount++
        } else {
            notXCount++
        }
        if (xCount == notXCount) {
            answer.add(s.substring(idx..i))
            x = ' '
        }
    }
    return if (answer.joinToString("") == s) {
        answer.size
    } else answer.size+1
}