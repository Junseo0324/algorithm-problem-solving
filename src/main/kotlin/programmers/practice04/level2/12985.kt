package programmers.practice04.level2

fun main() {

}

fun solution12985(n: Int, a: Int, b: Int): Int {
    var answer = 0
    var one = a
    var two = b
    while (one != two) {
        one = (one + 1) / 2
        two = (two + 1) / 2
        answer++
    }

    return answer
}