package BOJ.greedy

/**
 * 가장 작은 최솟값을 만들기.
 * [작은 수 - 가장 큰 수] 형태? -> x
 * +를 모두 다 한 뒤에 - 처리.
10 - 30 + 40 + 50 - 20 + 30
10 - 120 - 50 이런 식의 형태로 만들기. + 먼저 실행?
 *
 * 1. - 기준으로 split => str
 * 2. str.forEach { split(+) } ?  map ?
 */
fun main() {
    var answer = readln().split("-").map { s -> s.split("+")
        .sumOf { it.toInt() } }.reduce{acc,t -> acc-t}
    println(answer)
}