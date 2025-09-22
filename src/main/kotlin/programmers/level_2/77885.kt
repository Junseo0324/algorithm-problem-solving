package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/77885

fun solution77885(numbers: LongArray): LongArray {
    return numbers.map { x ->
        if (x % 2L == 0L) {
            x + 1L
        } else {
            val lowestZero = (x.inv() and (x + 1L))
            val result = (x or lowestZero) and (lowestZero shr 1).inv()
            result
        }
    }.toLongArray()
}

fun main() {
    println(
        solution77885(
            longArrayOf(2,7)
        )
    )
}