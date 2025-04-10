package BOJ.greedy

/**
 * 회의실 배정
 * 그리디
 * 현재 회의 종료 시간이 빠를수록 다음 회의와 겹치지 않게 시작하는 데 유리
        1. 종료 시간이 빠른 순서대로 정렬
            - 종료 시간이 같을 경우 -> 시작시간 기준 정렬.
        2. for문으로 데이터 확인 (count++)
 */
fun main() {
    val n = readln().toInt()
    val array = Array(n) {Array(2) {0} }
    var count = 0
    repeat(n) {
        var input = readln().split(" ")
        array[it][0] = input[0].toInt() //시작시간
        array[it][1] = input[1].toInt() //끝나는 시간
    }

    array.sortWith(compareBy<Array<Int>> {it[1]}.thenBy { it[0] })

    var time = array[0][1]

    for (i in 1 until array.size) {
        if (time <= array[i][0]) {
            time = array[i][1]
            count++
        }
    }

    println(count+1)

}