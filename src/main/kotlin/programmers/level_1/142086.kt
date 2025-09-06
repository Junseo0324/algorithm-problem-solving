package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/142086

fun solution142086(s: String): IntArray {
    val answer = mutableListOf<Int>()
    val list = mutableListOf<Char>()
    for (i in 0 until s.length) {
        if (list.contains(s[i])) {
            answer.add(i-list.indexOfLast {it == s[i]})
            list.add(s[i])
        } else {
            answer.add(-1)
            list.add(s[i])
        }
    }

    return answer.toIntArray()

}


fun main() {
    println(solution142086("banana"))
}