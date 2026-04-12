package programmers.practice04.level1

fun main() {

}

fun solution68644(numbers: IntArray): IntArray {
    var answer = mutableSetOf<Int>()
    for (i in numbers.indices) {
        for (j in numbers.indices) {
            if (i != j) {
                answer += numbers[i] + numbers[j]
            }
        }
    }
    return answer.sorted().toIntArray()
}