package BOJ.implementation

// https://www.acmicpc.net/problem/1316

/**
 * 그룹 단어
 */
fun main() {
    val n = readln().toInt()
    var answer = 0
    repeat(n) {
        val str = readln()
        val useWord = mutableListOf<Char>()
        var last: Char? = null
        var isGroup = true

        for (c in str) {
            if (c != last) {
                if (c in useWord) {
                    isGroup = false
                    break
                }
                useWord.add(c)
            }
            last = c
        }
        if (isGroup) answer++
    }
    println(answer)
}