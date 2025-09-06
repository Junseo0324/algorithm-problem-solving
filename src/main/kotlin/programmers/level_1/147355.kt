package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/147355

fun solution147355(t: String, p: String): Int {
    var answer = 0
    for (i in 0 ..t.length-p.length) {
        if (t.substring(i,i+p.length) <= p) {
            answer++
        }
    }
    return answer
}

fun main() {
    println(solution147355("500220839878","7"))

}