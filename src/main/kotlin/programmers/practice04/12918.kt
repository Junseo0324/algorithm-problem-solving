package programmers.practice04

fun solution12918(s: String): Boolean {
    var answer = true
    if ((s.length == 4 || s.length == 6) && s.filterNot { it.isDigit() }.isEmpty()) {
        answer = true
    } else {
        answer = false
    }
    return answer
}