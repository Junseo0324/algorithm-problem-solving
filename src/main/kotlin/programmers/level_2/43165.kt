package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/43165
/**
 * n개의 음이 아닌 정수들이 있다. 이 정수들을 순서를 바꾸지 않고 더하거나 빼서 타겟 넘버를 만든다.
 * numbers : 사용할 숫자가 담긴 배열 / target: 타겟 넘버
 * 만들 수 있는 타겟 넘버를 만드는 방법의 수를 return
 *
 * 순서 보장 , + , - 만 조절하면 됨.
 */
fun solution43165(numbers: IntArray, target: Int): Int {
    var answer = 0

    fun dfs(i: Int, sum: Int) {
        if (i == numbers.size) {
            if (sum == target) {
                answer++
            }
        }
        else {
            dfs(i+1, sum + numbers[i])
            dfs(i+1, sum - numbers[i])
        }
    }

    dfs(0,0)
    return answer
}



fun main() {
    println(solution43165(intArrayOf(1,1,1,1,1),3))
    println(solution43165(intArrayOf(4,1,2,1),4))
}