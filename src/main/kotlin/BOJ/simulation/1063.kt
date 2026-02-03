package BOJ.simulation

/**
 * 8*8크기의 체스판에 왕이 하나 있다. 킹의 현재 위치가 주어진다.
 * 체스판에서 말의 위치는 다음과 같이 주어진다.
 * 알파벳 하나와 숫자 하나로 이루어져 있는데, 알파벳은 열을 상징하고, 숫자는 행을 상징한다.
 * 열은 가장 왼쪽 열이 A이고, 가장 오른쪽 열이 H까지 이고, 행은 가장 아래가 1이고 가장 위가 8이다.
 * 예를 들어, 왼쪽 아래 코너는 A1이고, 그 오른쪽 칸은 B1이다.
 *
 * 킹은 다음과 같이 움직일 수 있다.
 *
 * R : 한 칸 오른쪽으로
 * L : 한 칸 왼쪽으로
 * B : 한 칸 아래로
 * T : 한 칸 위로
 * RT : 오른쪽 위 대각선으로
 * LT : 왼쪽 위 대각선으로
 * RB : 오른쪽 아래 대각선으로
 * LB : 왼쪽 아래 대각선으로
 * 체스판에는 돌이 하나 있는데, 돌과 같은 곳으로 이동할 때는, 돌을 킹이 움직인 방향과 같은 방향으로 한 칸 이동시킨다. 아래 그림을 참고하자.
 *
 *
 */
fun main() {
    val input = readln().split(" ")
    var king = input[0][0] - 'A' to input[0][1] - '1'
    var stone = input[1][0] - 'A' to input[1][1] - '1'
    val n = input[2].toInt()

    val moveMap = mapOf(
        "R" to (1 to 0), "L" to (-1 to 0), "B" to (0 to -1), "T" to (0 to 1),
        "RT" to (1 to 1), "LT" to (-1 to 1), "RB" to (1 to -1), "LB" to (-1 to -1)
    )

    repeat(n) {
        val move = readln()
        val (dc, dr) = moveMap[move]!!

        val nextKing = king.first + dc to king.second + dr

        if (nextKing.first in 0..7 && nextKing.second in 0..7) {
            if (nextKing == stone) {
                val nextStone = stone.first + dc to stone.second + dr

                if (nextStone.first in 0..7 && nextStone.second in 0..7) {
                    king = nextKing
                    stone = nextStone
                }
            } else {
                king = nextKing
            }
        }
    }

    println("${(king.first + 'A'.toInt()).toChar()}${king.second + 1}")
    println("${(stone.first + 'A'.toInt()).toChar()}${stone.second + 1}")


}