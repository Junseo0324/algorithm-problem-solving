package programmers.stack_queue

// https://school.programmers.co.kr/learn/courses/30/lessons/42586
/**
 * 각 기능은 진도가 100% 일 때 서비스에 반영할 수 있습니다.
 *
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
 * 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 *
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
 * 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
 * 각 배포마다 몇 개의 기능이 배포되는지를 return
 *
 * 제한 사항
 *
 * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
 * 작업 진도는 100 미만의 자연수입니다.
 * 작업 속도는 100 이하의 자연수입니다.
 * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
 * while(true) {
 * 하루에 한번 더하기. 그니까 progresses 에 더해 쭉.. 더한 후에 비교 if(stack.peek()==100) answer++ stack.removeLast()
 */


fun solution42586(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = mutableListOf<Int>()
    val q = ArrayDeque<Int>()
    for (i in progresses.indices) {
        val remain = (100 - progresses[i] + speeds[i] - 1) / speeds[i]
        q.add(remain)
    }

    while (q.isNotEmpty()) {
        val day = q.removeFirst()
        var count = 1
        while (q.isNotEmpty() && q.first() <= day) {
            q.removeFirst()
            count++
        }
        answer.add(count)
    }
    return answer.toIntArray()
}

fun main() {

    println(
        solution42586(
            intArrayOf(93, 30, 55),
            intArrayOf(1, 30, 5)
        )
    )

    println(
        solution42586(
            intArrayOf(95, 90, 99, 99, 80, 99),
            intArrayOf(1, 1, 1, 1, 1, 1)
        )
    )
}