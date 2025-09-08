package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/155652

/**
 * 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 change
 * index만큼의 뒤의 알파벳이 z -> a로 돌아갑니다.
 * skip에 있는 알파벳은 제외하고 건너뜁니다.
 * abcde fghij klmno pqrst uvwxy z = 26 z=122, a =97
 * 122-25 = 97
 */
fun solution155652(s: String, skip: String, index: Int): String {
    var answer = ""
    for (c in s) {
        var check = c.toInt()
        var count = 0
        while (count != index) {
            count++
            if (check+1 > 122) {
                check = 97
            } else {
                check++
            }
            while (skip.contains(check.toChar())) {
                check++
                if (check>122) {
                    check = 97
                }
            }
        }
        answer +=check.toChar()
    }

    return answer
}

fun main() {
    println(solution155652("aukks", "wbqd", 5))
}