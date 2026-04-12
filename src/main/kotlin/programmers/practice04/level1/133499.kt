package programmers.practice04.level1

fun main() {
    println(solution133499(arrayOf("aya", "yee", "u", "maa")))
    println(solution133499(arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa")))
    println(solution133499(arrayOf("aye")))
}


fun solution133499(babbling: Array<String>): Int {
    val speaking = listOf("aya", "ye", "woo", "ma")
    var count = 0
    for (word in babbling) {
        if (word.contains("ayaaya") || word.contains("yeye") ||
            word.contains("woowoo") || word.contains("mama")
        ) {
            continue
        }
        var newWord = word
        for (speak in speaking) {
            newWord = newWord.replace(speak, " ")
        }
        if (newWord.replace(" ", "").isEmpty()) {
            count++
        }
    }
    return count
}