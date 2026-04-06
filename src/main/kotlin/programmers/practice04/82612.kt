package programmers.practice04

fun solution82612(price: Int, money: Int, count: Int): Long {
    var answer = money.toLong()
    repeat(count) {
        val targetPrice = price * (it + 1)
        answer -= targetPrice
    }


    return if (answer >= 0) 0L else -answer
}