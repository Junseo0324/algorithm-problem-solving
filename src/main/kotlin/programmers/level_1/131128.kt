package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/131128?language=kotlin

fun solution131128(X: String, Y: String): String {
    var xList = X.map { it.digitToInt() }.sorted().toMutableList()
    var yMap = Y.groupingBy { it.digitToInt() }.eachCount().toMutableMap()
    var result = mutableListOf<Int>()
    for (x in xList) {
        if ((yMap[x] ?: 0 )> 0) {
            result.add(x)
            yMap[x] = yMap.getOrDefault(x,0)-1
        }
    }
    result = result.sortedDescending().toMutableList()
    return if (result.isEmpty())
        "-1"
    else if (result.all { it == 0 })
        "0"
    else result.joinToString("")
}


fun main() {
    println(solution131128("100", "2345"))
    println(solution131128("100", "203045"))
    println(solution131128("100", "123450"))
    println(solution131128("12321", "42531"))
    println(solution131128("5525", "1255"))
}