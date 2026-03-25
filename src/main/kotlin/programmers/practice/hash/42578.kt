package programmers.practice.hash

fun main() {
    println(
        solution42578(
            arrayOf(
                arrayOf("yellow_hat", "headgear"),
                arrayOf("blue_sunglasses", "eyewear"),
                arrayOf("green_turban", "headgear")
            )
        )
    )
    println(
        solution42578(
            arrayOf(
                arrayOf("crow_mask", "face"),
                arrayOf("blue_sunglasses", "face"),
                arrayOf("smoky_makeup", "face")
            )
        )
    )
}

fun solution42578(clothes: Array<Array<String>>): Int {
    val hashMap = mutableMapOf<String, Int>()
    for (cloth in clothes) {
        hashMap[cloth[1]] = hashMap.getOrDefault(cloth[1], 0) + 1
    }

    return hashMap.values.map { it + 1 }.reduce { acc, i -> acc * i } -1
}