package programmers.practice04.level1

fun solution12943(num: Int): Int {
    var answer = 0
    var number = num
    while (true) {
        if (answer == 500) {
            answer = -1
            break
        }
        if (number == 1) {
            break
        }
        if (number % 2 == 0) {
            number /= 2
        } else if (number % 2 == 1) {
            number = number * 3 + 1
        }
        answer++
    }
    return answer
}
