package programmers.practice04

fun main() {
    println(solution12917("Zbcdefg"))
}
fun solution12917(s: String): String {
    val list = s.toList().sortedDescending()
    return list.joinToString("")
}