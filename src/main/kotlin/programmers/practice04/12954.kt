package programmers.practice04

fun solution12954(x: Int, n: Int): LongArray {
    var answer = longArrayOf()
    repeat(n) {
        answer += x.toLong() * (it+1)
    }
    return answer
}