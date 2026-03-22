package BOJ.trytty

fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val list = IntArray(n+1)

        for (i in 0 until n) {
            val (doc,interview) = readln().split(" ").map { it.toInt() }
            list[doc] = interview
        }

        var count = 1

        var minInterviewRank = list[1]

        for (i in 2..n) {
            if (list[i] < minInterviewRank) {
                count++
                minInterviewRank = list[i]
            }
        }

        println(count)
    }
}