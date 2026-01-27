package BOJ.implementation


/**
 * 점수 -> 12시 방향(arr[0] s = 1 , 2 , 4 , 8 )
 *
 */

// 돌린 뒤 뒤에 a가 존재할 경우
// 2 와 6 을 비교? 다른건 필요없음
// 미리 돌려야 될 걸 정해놓고 for 문으로 돌리기. k = 100 , rotate 는 4개만 체크 400 번? ㄱㅊ

fun main() {
    // n: 0 , s: 1 로 표현
    val arr = Array(4) { ArrayDeque(readln().map { it.digitToInt() }) }
    val n = readln().toInt()

    repeat(n) {
        val (idx, direction) = readln().split(" ").map { it.toInt() }
        val gearIdx = idx - 1
        val rotateArr = IntArray(4)
        rotateArr[gearIdx] = direction

        // 나보다 왼쪽 체크
        for (i in gearIdx downTo 1) {
            if (arr[i - 1][2] != arr[i][6]) {
                rotateArr[i - 1] = -rotateArr[i]
            } else break
        }

        // 나보다 오른쪽 체크
        for (i in gearIdx until 3) {
            if (arr[i][2] != arr[i + 1][6]) {
                rotateArr[i + 1] = -rotateArr[i]
            } else break
        }

        for (i in 0 until 4) {
            when {
                rotateArr[i] == 1 -> {
                    arr[i].addFirst(arr[i].removeLast())
                }

                rotateArr[i] == -1 -> {
                    arr[i].addLast(arr[i].removeFirst())
                }
            }
        }
    }

    var answer = 0
    for (i in arr.indices) {
        if (arr[i][0] == 1) {
            answer += 1 shl i
        }
    }

    println(answer)
}