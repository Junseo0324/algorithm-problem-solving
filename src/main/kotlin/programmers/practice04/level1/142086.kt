package programmers.practice04.level1

fun main() {
    println(solution142086("banana"))
    println(solution142086("foobar"))
}

fun solution142086(s: String): MutableList<Int> {
    var answer = mutableListOf<Int>()
    answer += -1
    for (i in s.indices) {
        for (j in i - 1 downTo 0) {
            if (s[i] == s[j]) {
                answer += i - j
                break
            }
        }
        if (answer.size != i+1) {
            answer += -1
        }
    }
    return answer
}