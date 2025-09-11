package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/131701

/**
 * 원형 수열의 연속하는 부분 수열의 합으로 만들 수 있는 수가 모두 몇 가지인지? -> set 이용
 *  < 3elements < 1000  //
 *  ex) 5개의 원소 일 경우 2개의 합  0,1 / 1,2, / 2,3, / 3,4 / 4,5    elements[idx % elements.size]
 */
fun solution131701(elements: IntArray): Int {
    val set = mutableSetOf<Int>()
    val size = elements.size

    //부분 합 이용 방식
    val extended = elements + elements
    val prefixSum = IntArray(extended.size + 1)

    for (i in 1..extended.size) {
        prefixSum[i] = prefixSum[i-1] + extended[i-1]
    }

    for (len in 1..size) {
        for (start in 0 until size) {
            val sum = prefixSum[start+len] - prefixSum[start]
            set.add(sum)
        }
    }

    //내가 한 방식
    for (i in 1..size) {
        for (j in 0 until size) {
            var sum = 0
            for (k in j until j + i) {
                sum += elements[k % size]
            }
            set.add(sum)
        }
    }
    return set.size
}


fun main() {
    println(solution131701(intArrayOf(7, 9, 1, 1, 4)))
}