package BOJ.trytty

fun main() {
    val n = readln().toInt()
    var board = Array(n) { readln() }

    var row = 0
    var col = 0

    for (i in 0 until n) {
        var rowCount = 0
        var colCount = 0

        for (j in 0 until n) {
            if (board[i][j] == '.') {
                rowCount++
            } else {
                if (rowCount >=2) row++
                rowCount = 0
            }

            if (board[j][i] =='.') {
                colCount++
            } else {
                if (colCount >=2) col++
                colCount = 0
            }
        }

        if (rowCount >=2) row++
        if (colCount >=2) col++
    }

    println("$row $col")
}