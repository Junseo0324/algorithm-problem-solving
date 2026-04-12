package programmers.practice04.level1

fun main() {
    println(
        solution64061(
            board = arrayOf(
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 1, 0, 3),
                intArrayOf(0, 2, 5, 0, 1),
                intArrayOf(4, 2, 4, 4, 2),
                intArrayOf(3, 5, 1, 3, 1),
            ),
            moves = intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
        )
    )
}

fun solution64061(board: Array<IntArray>, moves: IntArray): Int {
    var answer = 0
    val n = board.size
    val stack = mutableListOf<Int>()
    val copyBoard = board
    for (move in moves) {
        for (i in 0 until n) {
            if (copyBoard[i][move-1] != 0) {
                if (stack.isNotEmpty()) {
                    if (stack.last() == copyBoard[i][move-1]) {
                        stack.removeLast()
                        answer +=2
                    } else {
                        stack.add(copyBoard[i][move-1])
                    }
                } else {
                    stack.add(copyBoard[i][move-1])
                }
                copyBoard[i][move-1] = 0
                break
            }
        }
    }

    return answer
}