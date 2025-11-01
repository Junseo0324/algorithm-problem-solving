package BOJ.implementation

// https://www.acmicpc.net/problem/25206

fun main() {
    var totalScore: Double = 0.0
    val gradeMap = mapOf(
        "A+" to 4.5,
        "A0" to 4.0,
        "B+" to 3.5,
        "B0" to 3.0,
        "C+" to 2.5,
        "C0" to 2.0,
        "D+" to 1.5,
        "D0" to 1.0,
        "F" to 0.0,
        "P" to 0.0,
    )
    var count = 0.0
    repeat(20) {
        val (_,creditStr,grade) = readln().split(" ")
        val credit = creditStr.toDouble()
        if (grade != "P") {
            val gradeScore = gradeMap.getOrDefault(grade, 0.0)
            var sum = credit * gradeScore
            count += credit
            totalScore += sum
        }
    }
    println(totalScore/count)
}