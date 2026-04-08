package programmers.practice04

fun main() {
    println(solution176963(
        name = arrayOf("may", "kein", "kain", "radi"),
        yearning = intArrayOf(5,10,1,3),
        photo = arrayOf(
            arrayOf("may", "kein", "kain", "radi"),
            arrayOf("may", "kein", "brin", "deny"),
            arrayOf("kon", "kain", "may", "coni"),
        )
    ))
}

fun solution176963(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
    var answer: IntArray = intArrayOf()

    for (pic in photo) {
        var score = 0
        for (people in pic) {
            if (people in name) {
                val idx = name.indexOf(people)
                score += yearning[idx]
            }
        }
        answer += score
    }
    return answer
}