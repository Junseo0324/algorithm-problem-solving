package programmers.practice04

fun main() {
    println(solution42889(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)))
    println(solution42889(4, intArrayOf(4, 4, 4, 4, 4)))
}

// 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
// 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return
fun solution42889(N: Int, stages: IntArray): IntArray {
    val array = mutableListOf<Double>()

    for (i in 1..N) {
        var fail = 0
        var challenge = 0
        for (stage in stages) {
            if (stage == i) {
                fail++
                challenge++
            } else if (stage > i) {
                challenge++
            }
        }
        if (challenge > 0) {
            array.add(fail / challenge.toDouble())
        } else {
            array.add(0.0)
        }
    }
    val list = array.withIndex().sortedByDescending { it.value }.map { it.index+1 }
    return list.toIntArray()
}