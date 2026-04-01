package programmers.practice.dfs_bfs

fun main() {
    println(solution43165(numbers = intArrayOf(1,1,1,1,1), target = 3))
    println(solution43165(numbers = intArrayOf(4,1,2,1), target = 4))
}

fun solution43165(numbers: IntArray, target: Int): Int {
    var answer = 0

    fun dfs(start: Int, sum: Int) {
        if (start == numbers.size) {
            if (sum == target) {
                answer++
            }
        }
        else {
            dfs(start+1, sum + numbers[start])
            dfs(start+1, sum - numbers[start])
        }
    }
    dfs(0,0)
    return answer


}