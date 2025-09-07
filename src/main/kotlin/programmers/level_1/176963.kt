package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/176963
/**
 * 3 <= name <= 7
 * 1 <= yearing <= 100
 * 3 <= photo <= 100
 * photo[i] <= 7
 * 100 * 7 * 7 * 100 = 10000 * 49  = 490000
 */
fun solution176963(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
    var answer: IntArray = intArrayOf()
    photo.forEach {
        var score = 0
        for (i in it.indices) {
            if (name.contains(it[i])) {
                val idx = name.indexOf(it[i])
                score += yearning[idx]
            }
        }
        answer+=score
    }
    return answer
}

fun main() {
    println(solution176963(
        arrayOf("may", "kein", "kain", "radi"),
        intArrayOf(5, 10, 1, 3),
        arrayOf(
            arrayOf("may", "kein", "kain", "radi"),
            arrayOf("may", "kein", "brin", "deny"),
            arrayOf("kon", "kain", "may", "coni"),
        )))
}