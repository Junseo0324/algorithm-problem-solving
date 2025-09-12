package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/131127
/**
 * banana3 apple 2 rice 2 pork2 pot 1 이 모두 있는 곳을 찾아라. discount에서
 * zip 이나 그런걸로 want & number 를 묶은 다음 discount 를 for 문을 돌면서 찾을 때마다 answer ++
 */
fun solution131127(want: Array<String>, number: IntArray, discount: Array<String>): Int {
    var answer= 0
    val wantList = want.zip(number.toTypedArray())

    for (i in 0 until discount.size - 10) { //날짜별로 비교
        val current = discount.slice(i until i+10)
        var currentCount = mutableMapOf<String,Int>()
        for (j in current) {
            currentCount[j] = currentCount.getOrDefault(j,0)+1
        }
        var same = true

        for ((k,v) in wantList) {
            if (currentCount.getOrDefault(k,0) != v) {
                same = false
                break
            }
        }

        if (same) answer++
    }
    return answer
}

fun main() {
    println(
        solution131127(
            arrayOf("banana", "apple", "rice", "pork", "pot"),
            intArrayOf(3,2,2,2,1),
            discount = arrayOf(
                "chicken", "apple", "apple", "banana", "rice", "apple", "pork",
                "banana", "pork", "rice", "pot", "banana", "apple", "banana"
            )
        )
    )
    println(
        solution131127(
            arrayOf("apple"),
            intArrayOf(10),
            discount = arrayOf(
                "banana", "banana", "banana", "banana", "banana", "banana",
                "banana", "banana", "banana", "banana"
            )
        )
    )
}
