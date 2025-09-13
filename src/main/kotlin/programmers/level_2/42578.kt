package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=kotlin

/**
 * headgear 2 , eyewear 1   -> 3 x 2 - 1 = 5
 * face 3    4 x 1 -1 = 3
 * (hashMap[key]+1) x ~~~~ -1
 */

fun solution42578(clothes: Array<Array<String>>): Int {
    var answer = 1
    var hashMap = hashMapOf<String,Int>()

    for (cloth in clothes) {
        hashMap[cloth[1]] = hashMap.getOrDefault(cloth[1],1)+1
    }
    for ((_,v) in hashMap) {
        answer *=v
    }
    return if (hashMap.isNotEmpty()) answer -1 else 0
}

fun main() {
    println(solution42578(
        arrayOf(
            arrayOf("yellow_hat", "headgear"),
            arrayOf("blue_sunglasses", "eyewear"),
            arrayOf("green_turban", "headgear")
        )
    ))
}