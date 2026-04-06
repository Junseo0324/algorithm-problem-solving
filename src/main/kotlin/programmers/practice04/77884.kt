package programmers.practice04

fun solution77884(left: Int, right: Int): Int {
    var answer = 0
    fun isEven(x: Int): Boolean {
        var count = 0
        for (i in 1..x) {
            if (x % i == 0) {
                count++
            }
        }
        return count % 2 == 0
    }

    for (i in left..right) {
        if (isEven(i)) {
            answer += i
        } else {
            answer -= i
        }
    }
    return answer
}