package programmers.level_1
// https://school.programmers.co.kr/learn/courses/30/lessons/12931?language=kotlin

class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        var nStr = n.toString()
        answer = nStr.sumOf {
            it.digitToInt()
        }
        return answer

    }
}

fun main() {
    var solution = Solution()
    println(solution.solution(123))

}
