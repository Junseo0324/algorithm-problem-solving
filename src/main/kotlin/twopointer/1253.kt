package twopointer

fun main() {
    var n = readln().toInt()
    var m = readln().split(" ").map { it.toInt() }.sorted()

    var count = 0
    for (i in m.indices){
        var start = 0
        var end = n-1
        while (start < end) {
            if (start == i) {
                start++
                continue
            }
            if (end == i) {
                end--
                continue
            }
            if (m[start] + m[end] == m[i]) {
                count++
                break

            } else if (m[start] + m[end] > m[i]) {
                end--
            } else start++
        }
    }
    println(count)
}