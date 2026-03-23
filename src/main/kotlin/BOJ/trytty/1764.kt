package BOJ.trytty

fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }

    val listen = mutableSetOf<String>()
    val listenAndWatch = mutableListOf<String>()

    repeat(n) {
        listen.add(readln())
    }
    repeat(m) {
        val input = readln()
        if (input in listen) {
            listenAndWatch.add(input)
        }
    }

    println(listenAndWatch.size)
    println(listenAndWatch.sorted().joinToString("\n"))
}