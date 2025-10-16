package programmers.hash

// https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=kotlin
/**
 * [이름, 종류] 로 이루어져 있음.
 */
fun solution42578(clothes: Array<Array<String>>): Int {
    var answer = 1
    val hashMap = hashMapOf<String,Int>()

    clothes.forEach {
        hashMap[it[1]] = hashMap.getOrDefault(it[1],1)+1
    }
    for ((k,v) in hashMap) {
        answer *= v
    }
    return answer-1
}


fun main() {
    println(
        solution42578(
            arrayOf(
                arrayOf("yellow_hat","headgear"),
                arrayOf("blue_sunglasses","eyewear"),
                arrayOf("green_turban","headgear")
            )
        )
    )
    println(
        solution42578(
            arrayOf(
                arrayOf("crow_mask","face"),
                arrayOf("blue_sunglasses","face"),
                arrayOf("smoky_makeup","face")
            )
        )
    )
}