package programmers.practice04

fun main() {
    println(solution131128("100", "2345"))
    println(solution131128("100", "203045"))
    println(solution131128("100", "123450"))
    println(solution131128("12321", "42531"))
    println(solution131128("5525", "1255"))
}

fun solution131128(X: String, Y: String): String {
    var answer = ""
    val countX = IntArray(10)
    val countY = IntArray(10)

    for (char in X) {
        countX[char.digitToInt()]++
    }
    for (char in Y) {
        countY[char.digitToInt()]++
    }

    val sb = StringBuilder()

    for (i in 9 downTo 0) {
        val count = minOf(countX[i],countY[i])
        for (j in 0 until count) {
            sb.append(i)
        }
    }

    if (sb.isEmpty()) answer = "-1"
    else if(sb.toString() == "0".repeat(sb.length)) answer = "0"
    else answer = sb.toString()

    return answer
}