package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/12951

/**
 * 단어의 첫 문자 = 대문자, 그 외 소문자
 */
fun solution12951(s: String): String {
    var list = s.split(" ")
    var answer = mutableListOf<String>()
    list.forEach {
        if (it.isNotEmpty() && it[0].isLetter()) {
            answer.add(it[0].uppercase() + it.substring(1).lowercase())
        } else {
            answer.add(it.lowercase())
        }
    }
    return answer.joinToString(" ")
}

fun main() {
    println(solution12951("3people unFollowed me"))
    println(solution12951("for the last week"))
}