package programmers.greedy

fun main() {
    println(
        solution42860(name = "JEROEN")
    )
    println(
        solution42860(name = "JAN")
    )
}

// ABCDE FGHIJ KLMNO PQRST UVWXY Z : 26개
// 초기 시작은 무조건 'A'
fun solution42860(name: String): Int {
    var answer = 0

    // 문자 움직이는 횟수
    for (char in name) {
        val up = char - 'A'
        val down = 'Z' - char + 1
        answer += minOf(up, down)
    }

    // 좌우 판별
    var move = name.length - 1

    for (i in name.indices) {
        var next = i + 1
        while (next < name.length && name[next] == 'A') {
            next++
        }

        val returnMove = i * 2 + name.length - next
        val backAndRight = (name.length - next) * 2 + i

        move = minOf(move, minOf(returnMove, backAndRight))
    }
    return answer + move
}