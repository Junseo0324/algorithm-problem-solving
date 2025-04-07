package BOJ.array_List

fun main() {
    var n = readln().toInt()
    var arr = readln().split(" ").map { it.toInt() }


    println(arr.sum() * 100.0 / arr.max() / n)
}