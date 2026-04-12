package programmers.practice04.level2

fun main() {
    println(solution12951("3people unFollowd me"))
}

fun solution12951(s: String): String {
    val list = s.split(" ")
    val answer = mutableListOf<String>()
    for (str in list) {
        if (str.isNotEmpty() && str[0].isLetter()) {
            answer.add(str[0].uppercase() + str.substring(1).lowercase())
        } else {
            answer.add(str.lowercase())
        }
    }
    return answer.joinToString(" ")
}