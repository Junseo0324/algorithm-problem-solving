package BOJ.prime

/**
 * 정수 X - 1보다 큰 제곱수로 나누어 떨어지지 않을 때 -> 제곱 ㄴㄴ 수
 * 제곱 수 : 4 (2x2) 9 (3x3)
 * 에라토스테네스의 체 방식?
 *
 */


fun main() {
    var (min,max) = readln().split(" ").map { it.toLong() }

    val squaredNumbers = mutableListOf<Long>()
    var i = 2L
    while (i*i <= max) {
        squaredNumbers.add(i*i)
        i++
    }

    val range = (max-min+1).toInt()
    val isNotSquare = BooleanArray(range) {true}

    for (square in squaredNumbers) {
        val start = (min + square -1) / square * square

        for (j in start..max step square) {
            isNotSquare[(j -min).toInt()] = false
        }
    }
    var count = 0
    for (b in isNotSquare) {
        if (b) count++
    }

    println(count)


}
