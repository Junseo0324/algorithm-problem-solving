package BOJ.implementation

// https://www.acmicpc.net/problem/1193

fun main() {
    val x = readln().toInt()
    var line = 1
    var sum = 0

    while (x > sum + line) {
        sum += line
        line++
    }

    val temp = x - sum
    println(
        if (line % 2 == 0) {
            "$temp/${line - temp + 1}"
        } else {
            "${line - temp + 1}/$temp"
        }
    )
}
