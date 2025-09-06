package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/82612

fun solution82612(price: Int, money: Int, count: Int): Long {
    return if(
        ((1L..count.toLong()).sum()*price.toLong() - money) <0)
        0
    else (
            (1L..count.toLong()).sum()*price.toLong() - money
    )
}

fun main() {
    println(solution82612(3,20,4))
}