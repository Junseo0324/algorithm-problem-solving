package BOJ.implementation

fun main() {
    val (first,second, third) = readln().split(" ").map { it.toInt() }

    val fs = first == second
    val st = second == third
    val ft = first == third
    val all = (first == second && second == third)
    var answer = 0
    if (all) {
        answer += (10000 + first * 1000)
    } else if (fs || st || ft) {
        if (fs) {
            answer += (1000 + first * 100)
        } else if (st) {
            answer += (1000 + second * 100)
        } else {
            answer += (1000 + first * 100)
        }
    } else {
        val max = maxOf(first, maxOf(second,third))
        answer = max * 100
    }

    println(answer)
}