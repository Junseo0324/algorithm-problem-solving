package programmers.practice04.level2

fun main() {
    println(solution87390(3, 2, 5))
    println(solution87390(4, 7, 14))
}

fun solution87390(n: Int, left: Long, right: Long): IntArray {
    var answer = mutableListOf<Int>()

    for (i in left..right) {
        val x = (i % n).toInt()

        val y = (i / n).toInt()
        println("x: $x, y: $y")
        answer.add(maxOf(x+1,y+1))
    }
    println(answer)

    return answer.toIntArray()
}