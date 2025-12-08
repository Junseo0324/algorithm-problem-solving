package BOJ.implementation

// https://www.acmicpc.net/problem/1157

fun main() {
    val str = readln().uppercase()

    val list = IntArray(26) { 0 }
    for (c in str) {
        val index = c.code - 'A'.code
        list[index]++
    }

    var maxCount = -1
    var maxIndex = -1

    for (i in 0 until 26) {
        if (list[i] > maxCount) {
            maxCount = list[i]
            maxIndex = i
        }
    }
    var temp = 0
    for (data in list) {
        if (data == maxCount) {
            temp++
        }
    }
    if (temp > 1) {
        println("?")
    } else {
        println(('A'.code + maxIndex).toChar())
    }


}