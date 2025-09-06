package programmers.level_1


fun solution68935(n: Int): Int {
    return n.toString(3).reversed().toInt(3)
}

fun main() {
    println(solution68935(45))
}