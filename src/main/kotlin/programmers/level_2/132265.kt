package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/132265

/**
 * topping <= 1,000,000 10^6 O(n)
 * 롤케이크 자르기 -> 롤케이크 위의 토핑에 관심이 더 많음
 * 가짓수가 똑같으면 공평하다. -> 공평하지 않을 경우가 있을 수도 있음
 * 공평하게 자르는 방법의 수를 return
 */
fun solution132265(topping: IntArray): Int {
    var answer = 0
    val leftHashMap = hashMapOf<Int,Int>()
    val rightHashMap = hashMapOf<Int,Int>()

    for (t in topping) {
        rightHashMap[t] = rightHashMap.getOrDefault(t,0)+1
    }

    var lCount = 0
    var rCount = rightHashMap.size


    for (i in topping.indices) {
        val t = topping[i]

        leftHashMap[t] = leftHashMap.getOrDefault(t,0)+1
        if (leftHashMap[t] ==1) lCount++

        rightHashMap[t] = rightHashMap[t]!! -1
        if (rightHashMap[t] == 0) {
            rightHashMap.remove(t)
            rCount--
        }
        if (lCount == rCount) {
            answer++
        }
    }
    return answer
}

fun main() {
    println(solution132265(intArrayOf(1, 2, 1, 3, 1, 4, 1, 2)))
    println(solution132265(intArrayOf(1, 2, 3, 1, 4)))
}