package BOJ.implementation

fun main() {
    val n = readln().toInt()
    val array = mutableListOf<Pair<Int,Int>>()
    val answer = mutableListOf<Int>()
    repeat(n) {
        val (x,y) = readln().split(" ").map { it.toInt() }
        array.add(x to y)
    }


    for (i in array.indices) {
        var rank = 0
        for (j in array.indices) {
            if (i !=j) {
                if (array[i].first < array[j].first && array[i].second < array[j].second) {
                    rank++
                }
            }
        }
        answer.add(rank+1)
    }
    println(answer.joinToString(" "))
}