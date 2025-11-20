package BOJ.implementation

fun main() {
    val n = readln().toInt()
    val array = Array(n) { IntArray(n) }
    repeat(n) {
        array[it] = readln().map { if (it == '*') 1 else 0 }.toIntArray()
    }
    val heartList = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (array[i][j] == 1) {
                heartList.add(i + 1 to j)
                break
            }
        }
    }
    var heart = heartList.first()
    val (x, y) = heart.first + 1 to heart.second + 1
    val answer = mutableListOf<Int>()

    var count = 0
    for (i in heart.second - 1 downTo 0) {
        if (array[heart.first][i] == 1) {
            count++
        } else {
            break
        }
    }
    answer.add(count)

    count = 0
    for (i in heart.second + 1 until n) {
        if (array[heart.first][i] == 1) {
            count++
        } else {
            break
        }
    }
    answer.add(count)

    //허리
    count = 0
    for (i in heart.first + 1 until n) {
        if (array[i][heart.second] == 1) {
            count++
        } else {
            heart = i-1 to heart.second
            break
        }
    }
    answer.add(count)

    count = 0
    for (i in heart.first + 1 until n) {
        if (array[i][heart.second - 1] == 1) {
            count++
        } else {
            break
        }
    }
    answer.add(count)

    count = 0
    for (i in heart.first + 1 until n) {
        if (array[i][heart.second + 1] == 1) {
            count++
        } else {
            break
        }
    }
    answer.add(count)

    println("$x $y")
    println(answer.joinToString(" "))

}