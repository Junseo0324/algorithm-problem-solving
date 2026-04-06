package programmers.practice04

fun solution12903(s: String): String {
    return if (s.length % 2 == 1) {
        s[s.length / 2].toString()
    } else {
        s.substring(s.length / 2 - 1..s.length / 2)
    }
}