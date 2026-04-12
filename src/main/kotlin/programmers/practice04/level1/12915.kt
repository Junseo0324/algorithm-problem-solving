package programmers.practice04.level1

fun main() {
    println(solution12915(arrayOf("sun", "bed", "car"),1))
    println(solution12915(arrayOf("abce", "abcd", "cdx"),2))
}

fun solution12915(strings: Array<String>, n: Int): Array<String> {
    var answer = arrayOf<String>()
    var list = strings.sortedWith(compareBy<String> { it[n] }.thenBy { it })
    println(list)
    return answer
}