package BOJ.twopointer

fun main() {
    var n = readln().toInt()
    var m = readln().toInt()
    var arr = readln().split(" ").map { it.toInt() }.sorted()
    var start = 0
    var end = n-1
    var count = 0
    while (start < end) {
        if (arr[start] + arr[end] > m) {
            end--
        } else if (arr[start] + arr[end] < m) {
            start++
        } else {
            start++
            end--
            count++
        }
    }
    println(count)
}