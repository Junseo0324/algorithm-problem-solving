package programmers.practice04

fun main() {
    println(solution133502(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)))
    println(solution133502(intArrayOf(1, 3, 2, 1, 2, 1, 3, 1, 2)))
}

fun solution133502(ingredient: IntArray): Int {
    var answer = 0
    val hamburger = listOf(1, 2, 3, 1)
    val list = mutableListOf<Int>()
    for (i in ingredient.indices) {
        list.add(ingredient[i])
        if (list.size >= 4 && list.takeLast(4) == hamburger) {
            repeat(4) {
                list.removeLast()
            }
            answer++
        }
    }

    return answer
}