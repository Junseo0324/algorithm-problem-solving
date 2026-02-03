package BOJ.simulation

fun main() {
    val (h, w) = readln().split(" ").map { it.toInt() }
    val array = Array(h) { IntArray(w) }

    for(i in 0 until h) {
        val input = readln()
        var last = -1

        for (j in 0 until w) {
            if (input[j] == 'c') {
                last = 0
            } else if (last != -1) {
                last++
            }
            array[i][j] = last
        }
    }

    array.forEach {
        println(it.joinToString(" "))
    }


}