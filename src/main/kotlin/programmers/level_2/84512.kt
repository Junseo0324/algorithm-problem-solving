package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=kotlin
/**
 * 'A', 'E', 'I', 'O', 'U' 로 만들 수 있는 단어가 몇 번째이냐?
 * 5x5x5x5x5 = 625 x 5 = 3125
 * 216 x6 1296 x 6 7776~ 10000 완전 탐색
 */

fun solution84512(word: String): Int {
    var str = ""
    var strList = mutableListOf<String>()
    val wordArr = arrayOf('A', 'E', 'I', 'O', 'U',"")
    for (i in wordArr) {
        for (j in wordArr) {
            for (k in wordArr) {
                for (l in wordArr) {
                    for (m in wordArr) {
                        str += i
                        str += j
                        str += k
                        str += l
                        str += m
                        if (str !in strList) {
                            strList.add(str)
                        }
                        str = ""
                    }
                }
            }
        }
    }
    strList.sort()
    return strList.indexOf(word)
}


fun main() {
    println(solution84512("AAAAE"))
}