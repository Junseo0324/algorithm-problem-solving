package programmers.practice04.level2

fun main() {

}

fun solution42578(clothes: Array<Array<String>>): Int {
    val hashMap = mutableMapOf<String, Int>()

    for (cloth in clothes) {
        hashMap[cloth[1]] = hashMap.getOrDefault(cloth[1], 0) + 1
    }

    return hashMap.values.map { it + 1 }.reduce { acc, i -> acc * i } - 1
}
