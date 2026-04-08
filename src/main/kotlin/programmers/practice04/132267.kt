package programmers.practice04

fun main() {
    println(solution132267(2, 1, 20))
    println(solution132267(3,1,20))
    println(solution132267(3,2,20))
}

fun solution132267(a: Int, b: Int, n: Int): Int {
    var answer = 0
    var bottle = n
    while (true) {
        if (bottle < a || bottle < 2) {
            break
        }
        if (bottle % a == 0) {
            answer += bottle / a * b
            bottle = bottle / a * b
        } else {
            answer += bottle / a * b
            bottle = bottle / a * b + bottle % a
        }
    }
    return answer
}