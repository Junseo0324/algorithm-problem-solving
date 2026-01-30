package BOJ.simulation

fun main() {
    val row = IntArray(26)
    val col = IntArray(26)

    for (i in 0 until 5) {
        readln().split(" ").forEachIndexed { index, s ->
            val num = s.toInt()
            row[num] = i
            col[num] = index
        }
    }

    val markedArray = Array(5) { BooleanArray(5) }

    val checkedNumbers = (1..5).flatMap { readln().split(" ").map { it.toInt() } }

    for (i in checkedNumbers.indices) {
        val num = checkedNumbers[i]
        markedArray[row[num]][col[num]] = true
        if (checkBingo(markedArray) >= 3) {
            println(i+1)
            return
        }
    }
}


fun checkBingo(markArray: Array<BooleanArray>): Int {
    var count = 0
    for (i in 0 until 5) {
        if ((0 until 5).all { j -> markArray[i][j] }) count++
        if ((0 until 5).all { j -> markArray[j][i] }) count++
    }

    if ((0 until 5).all { i -> markArray[i][i] }) count++
    if ((0 until 5).all { i -> markArray[i][4-i] }) count++

    return count
}
