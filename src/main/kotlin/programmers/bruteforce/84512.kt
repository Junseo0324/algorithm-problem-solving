package programmers.bruteforce

// https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=kotlin

fun solution84512(word: String): Int {
    var str = ""
    val strSet = mutableSetOf<String>()
    val wordList = arrayOf('A', 'E', 'I', 'O', 'U',"")
    for (i in wordList) {
        for (j in wordList) {
            for (k in wordList) {
                for (l in wordList) {
                    for (m in wordList) {
                        str += i
                        str += j
                        str += k
                        str += l
                        str += m
                        strSet.add(str)
                        str = ""
                    }
                }
            }
        }
    }
    return strSet.sorted().indexOf(word)
}

fun main() {
    println(solution84512("AAAAE"))
    println(solution84512("AAAE"))
    println(solution84512("I"))
    println(solution84512("EIO"))
}