package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/133499?language=kotlin

fun solution133499(babbling: Array<String>): Int {
    var answer = 0
    val wordArr = arrayOf("aya", "ye", "woo", "ma")
    for (s in babbling) {
        var idx = 0
        var prev = ""
        var valid = true

        while (idx < s.length) {
            var matched = false
            for (w in wordArr) {
                if (s.startsWith(w,idx) && w !=prev) {
                    idx+=w.length
                    prev = w
                    matched = true
                    break
                }
            }
            if (!matched) {
                valid = false
                break
            }
        }
        if (valid) answer++
    }
    return answer
}

fun main() {
    println(solution133499(arrayOf("aya", "yee", "u", "maa")))
    println(solution133499(arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa")))
}