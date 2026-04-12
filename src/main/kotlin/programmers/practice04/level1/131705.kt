package programmers.practice04.level1

fun main() {
    solution131705(intArrayOf(-2, 3, 0, 2, -5))
}

fun solution131705(number: IntArray): Int {
    var answer: Int = 0
    for (i in 0 until number.size) {
        for (j in i + 1 until number.size) {
            for (k in j + 1 until number.size) {
                if (number[i] + number[j] + number[k] == 0) {
                    println("${number[i]} ${number[j]} ${number[k]}")
                    answer++
                }
            }
        }
    }
    return answer
}