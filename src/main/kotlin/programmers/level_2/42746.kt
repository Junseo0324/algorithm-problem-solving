package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/42746

/**
 * 0 or 양의 정수가 주어졌을 때 정수를 이어 붙여 만들 수 있는 가장 큰 수
 * 1<=numbers <= 100,000
 * 문자열로 return
 */

fun solution42746(numbers: IntArray): String {
    val list = numbers.map {
        it.toString()
    }.sortedWith { a,b ->
        (b+a).compareTo(a+b)
    }.joinToString("")

    return if (list[0]!='0') list else "0"
}


fun main() {
    println(solution42746(intArrayOf(6,10,2)))
    println(solution42746(intArrayOf(3,30,34,5,9)))
}

