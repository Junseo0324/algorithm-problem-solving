package programmers.practice04.level1

fun main() {
    println(solution155652("aukks", "wbqd", 5))
}

fun solution155652(s: String, skip: String, index: Int): String {
    var answer = ""
    for (c in s) {
        var move = 0
        var current = c

        while (move < index) {
            current = if (current == 'z') 'a' else current + 1

            if (current !in skip) {
                move++
            }
        }

        answer +=current
    }
    return answer
}