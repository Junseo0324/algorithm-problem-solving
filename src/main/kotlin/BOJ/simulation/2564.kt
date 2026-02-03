package BOJ.simulation

fun main() {
    val (w, h) = readln().split(" ").map { it.toInt() }
    val n = readln().toInt()

    val list = mutableListOf<Pair<Int, Int>>()

    var answer = 0

    repeat(n) {
        val (directions, distance) = readln().split(" ").map { it.toInt() }
        when (directions) {
            1 -> list.add(0 to distance)
            2 -> list.add(h to distance)
            3 -> list.add(distance to 0)
            4 -> list.add(distance to w)
        }
    }

    val input = readln().split(" ").map { it.toInt() }
    when (input[0]) {
        1 -> list.add(0 to input[1])
        2 -> list.add(h to input[1])
        3 -> list.add(input[1] to 0)
        4 -> list.add(input[1] to w)
    }

    val curr = list.removeLast()
    println(list)
    println(curr)

    if (input[0] == 1 || input[0] == 2) { // 북쪽이나 남쪽인 경우?
        for (shop in list) {
            val shopX = shop.first
            val shopY = shop.second

        }
    } else {

    }



}