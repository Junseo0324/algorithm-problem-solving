package BOJ.trytty

fun main() {
    val (n, score, p) = readln().split(" ").map { it.toInt() }

    val list = if (n > 0) readln().split(" ").map { it.toInt() } else emptyList()

    if (n == p && list.last() >= score) {
        println(-1)
        return
    }

    var rank = 1

    for (i in list.indices) {
        if (list[i] > score) {
            rank++
        } else {
            break
        }
    }

    println(rank)

}
