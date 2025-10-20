package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/388351
/**
 * 출근 희망 시각에 늦지 않고 출근한 직원들에게 상품을 주는 이벤트를 진행
 * 출근 희망 시각 + 10분까지 어플로 출근
 * 9시 58분인 직원은 10시 8분까지 출근해야 함.
 * 토, 일은 영향 x
 * 직원들은 매일 한 번씩만 어플로 출근, 모든 시각은 시에 100을 곱하고 분을 더한 정수로 표현?
 * startday -> 1 월 2 화 ~~~ 5 금 6 토 7 일
 *
 * schedules < 1000 // timelogs <- 1000
 * timelogs[i][j] = i+1번째 직원이 이벤트 j+1일
 */

fun solution388351(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
    var answer = 0
    val list = schedules.map { hourToMin(it) + 10 }
    for (i in timelogs.indices) {
        var count = 0
        for (j in timelogs[i].indices) {
            val curr = (j + startday -1) % 7 + 1
            if (curr != 6 && curr != 7) {
                val time = hourToMin(timelogs[i][j])
                val listTime = list[i]
                if (time <= listTime) {
                    count++
                }
            }
            if (count == 5) {
                answer++
                break
            }
        }
    }

    return answer
}

fun hourToMin(time: Int): Int {
    val hour = time / 100
    val min = time % 100
    return (hour * 60) + min
}


fun main() {
    println(
        solution388351(
            intArrayOf(700, 800, 1100),
            arrayOf(
                intArrayOf(710, 2359, 1050, 700, 650, 631, 659),
                intArrayOf(800, 801, 805, 800, 759, 810, 809),
                intArrayOf(1105, 1001, 1002, 600, 1059, 1001, 1100)
            ),
            5
        )
    )
    println(
        solution388351(
            intArrayOf(730, 855, 700, 720),
            arrayOf(
                intArrayOf(710, 700, 650, 735, 700, 931, 912),
                intArrayOf(908, 901, 805, 815, 800, 831, 835),
                intArrayOf(705, 701, 702, 705, 710, 710, 711),
                intArrayOf(707, 731, 859, 913, 934, 931, 905),
            ),
            1
        )
    )
}