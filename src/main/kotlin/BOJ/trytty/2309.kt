package BOJ.trytty

fun main() {
    val list = mutableListOf<Int>()
    repeat(9) {
        list.add(readln().toInt())
    }

    val diff = list.sum() - 100
    var first = -1
    var second = -1
    for (i in 0 until 9) {
        if (first != -1) break
        for (j in 1 until 9) {
            if (list[i] + list[j] == diff) {
                first = list[i]
                second = list[j]
                break
            }
        }
    }

    println(list.filter { it != first && it != second }.sorted().joinToString("\n"))


}