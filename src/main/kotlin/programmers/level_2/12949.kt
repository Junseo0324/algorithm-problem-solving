package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/12949

/**
 * ㅎ
 */
fun solution12949(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
    val answer = Array(arr1.size){IntArray(arr2[0].size)}

    for (i in arr1.indices) {
        for (j in arr2[0].indices) {
            for (k in arr1[0].indices) {
                answer[i][j] = arr1[i][k] * arr2[k][j]
            }
        }
    }
    return answer
}

fun main() {
    println(solution12949(
        arrayOf(
            intArrayOf(1,4),
            intArrayOf(3,2),
            intArrayOf(4,1)
        ),
        arrayOf(
            intArrayOf(3,3),
            intArrayOf(3,3)
        )
    ))
}