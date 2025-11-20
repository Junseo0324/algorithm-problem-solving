package BOJ.implementation

fun main() {
    val input = readln().split(" ")
    val n = input[0].toInt()
    var game = when (input[1]) {
        "Y" -> 1
        "F" -> 2
        else -> 3
    }
    val set = mutableSetOf<String>()
    repeat(n) {
        set.add(readln())
    }

    println(set.count() / game)
}