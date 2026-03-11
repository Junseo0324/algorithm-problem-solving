package BOJ.implementation


fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val array = Array(n) { IntArray(m) }
    repeat(n) {
        array[it] = readln().map { it.digitToInt() }.toIntArray()
    }
    val answer = mutableListOf<Int>()

    val min = if (n > m) m else n

    for (i in 0..min) { // 정사각형의 크기
        for (j in 0 until n-i) { // 행
            for (k in 0 until m-i) { // 열
                if (array[j][k] == array[j + i][k] && array[j][k+i]== array[j+i][k+i] && array[j][k+i] == array[j][k]) {
                    answer.add((i+1)*(i+1))
                }
            }
        }
    }

    println(answer.max())

}