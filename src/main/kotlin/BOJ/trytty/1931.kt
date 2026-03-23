package BOJ.trytty

fun main() {
    val n = readln().toInt()
    val array = mutableListOf<Pair<Int,Int>>()
    repeat(n) {
        val (start,end) = readln().split(" ").map { it.toInt() }
        array.add(start to end)
    }

    val sortedList = array.sortedWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })
    var current = 0
    var answer = 0
    for ((start,end) in sortedList) {
        if (current <=start) {
            current = end
            answer++
        }
    }

    println(answer)
}