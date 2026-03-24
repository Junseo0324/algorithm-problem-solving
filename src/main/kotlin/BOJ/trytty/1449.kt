package BOJ.trytty

fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }

    var waterArr = BooleanArray(1001) { false }
    for (water in list) {
        waterArr[water] = true
    }


    var count = 0

    for (i in waterArr.indices) {
        if (waterArr[i]) {
            for (j in i+1 until minOf(i+l,1001)) {
                if (waterArr[j]) {
                    waterArr[j] = false
                }
            }
            waterArr[i] = false
            count++
        }
    }

    println(count)
}