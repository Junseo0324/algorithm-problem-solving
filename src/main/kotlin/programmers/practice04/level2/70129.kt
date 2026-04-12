package programmers.practice04.level2

fun main() {
    println(solution70129("110010101001"))
    println(solution70129("01110"))
    println(solution70129("1111111"))
}

fun solution70129(s: String): MutableList<Int> {
    val answer = mutableListOf<Int>()
    var count = 0
    var remove = 0
    var str = s
    while (true) {
        val size = str.length
        val one = str.count { it == '1' }
        str = one.toString(2)
        remove += size - one
        count += 1
        if (str == "1") {
            break
        }
    }
    answer.add(count)
    answer.add(remove)
    return answer
}