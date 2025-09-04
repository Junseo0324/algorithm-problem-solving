package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12928

//fun solution12928(n: Int): Int {
//    var answer = 0
//    for (i in 1 .. n) {
//        if (n % i ==0) {
//            answer +=i
//        }
//    }
//    return answer
//}

fun solution12928(n: Int): Int {
    return (1..n).filter { n % it == 0 }.sum()
}

fun main() {
    println(solution12928(3000))
}

