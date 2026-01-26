package BOJ.implementation

fun main() {
    repeat(readln().toInt()) {
        val array = readln().split(" ").map { it.toInt() }
        var total = 0
        var count = 0
        for (i in 1 until array.size) {
            total += array[i]
        }

        for (i in 1 until array.size) {
            if (array[i] > (total / array[0])) {
                count++
            }
        }

        val percent: Float = (count.toFloat() / array[0])
        println("%2.3f".format(percent * 100) + "%")

    }
}