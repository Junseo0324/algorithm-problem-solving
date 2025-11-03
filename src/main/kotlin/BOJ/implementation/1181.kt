package BOJ.implementation

fun main() {
    var answer = mutableListOf<String>()
    repeat(readln().toInt()) {
        val input = readln()
        if (!answer.contains(input)) {
            answer.add(input)
        }
    }
    answer = answer.sortedWith(compareBy({it.length},{it})).toMutableList()
    println(answer.joinToString("\n"))
}