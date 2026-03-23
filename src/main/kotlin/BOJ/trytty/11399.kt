package BOJ.trytty

fun main() {
    val n = readln().toInt()
    val array = readln().split(" ").map { it.toInt() }.sorted()


    var sum = 0
    for (i in array.indices) {
        sum += array[i]*(n-i)
    }

    println(sum)

}