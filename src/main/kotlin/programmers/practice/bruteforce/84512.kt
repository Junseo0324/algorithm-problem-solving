package programmers.practice.bruteforce

fun main() {
    println(solution84512("AAAAE"))
    println(solution84512("AAAE"))
    println(solution84512("I"))
    println(solution84512("EIO"))
}

fun solution84512(word: String): Int {
    var answer = mutableSetOf<String>()
    val wordList = listOf("A","E","I","O","U","")

    var word1 = ""
    for (i in wordList) {
        for (j in wordList) {
            for (k in wordList) {
                for (l in wordList) {
                    for (m in wordList) {
                        word1 += i
                        word1 += j
                        word1 += k
                        word1 += l
                        word1 += m
                        answer.add(word1)
                        word1 = ""
                    }
                }
            }
        }
    }
    return answer.sorted().indexOf(word)
}