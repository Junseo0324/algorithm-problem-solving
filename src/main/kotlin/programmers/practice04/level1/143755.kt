package programmers.practice04.level1

fun main() {
    println(solution143755("3141592", "271"))
    println(solution143755("500220839878", "7"))
    println(solution143755("10203", "15"))
}

fun solution143755(t: String, p: String): Int {
    var answer = 0
    val size = p.length
    for (i in 0..t.length - size) {
        if (t.substring(i, i + size) <= p) {
            answer++
        }
    }
    return answer
}