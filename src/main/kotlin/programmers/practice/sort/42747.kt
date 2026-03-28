package programmers.practice.sort

fun main() {
    println(
        solution42747(
            citations = intArrayOf(3, 0, 6, 1, 5)
        )
    )

    println(
        solution42747(
            citations = intArrayOf(4, 4, 4, 4, 4, 4)
        )
    )
}

fun solution42747(citations: IntArray): Int {
    var answer = 0
    val sortedCitations = citations.sortedDescending()
    for (citation in sortedCitations) {
        if (citation > answer) {
            answer += 1
        }
    }
    return answer
}