package programmers.practice04.level1

fun solution12950(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
    var answer = arrayOf<IntArray>()
    for (i in arr1.indices) {
        var arr = intArrayOf()
        for (j in arr1[i].indices) {
            arr += arr1[i][j] + arr2[i][j]
        }
        answer += arr
    }
    return answer
}