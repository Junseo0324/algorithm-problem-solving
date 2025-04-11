package BOJ.prime

/**
 * 1 <= A <= B <= 10^14
 * 범위 10^7
 */
fun main() {
    val (n,m) = readln().split(" ").map { it.toLong() }
    val array = LongArray(10000001)
    var count = 0L
    for (i in array.indices) {
        array[i] = i.toLong()
    }

    for (i in 2..Math.sqrt(array.size.toDouble()).toInt()) {
        if (array[i] == 0L) continue

        for (j in i+i until array.size step i) {
            array[j] = 0L
        }
    }

    for (i in 2..10000000) {
        if (array[i] !=0L) {
            var temp = array[i]
            while (array[i] <=m.toDouble() / temp.toDouble()) {
                if (array[i].toDouble() >= n.toDouble() / temp.toDouble()) count++
                temp *= array[i]
            }
        }
    }

    println(count)



}