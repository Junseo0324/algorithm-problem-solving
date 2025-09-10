package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/42862

/**
 * 도둑 ->
 * 전체 학생 n 2<=n<=30
 * lost -> 도난당한 학생들의 번호가 담긴 배열
 * reserve -> 여벌 옷이 있는 학생들.
 */
fun solution42862(n: Int, lost: IntArray, reserve: IntArray): Int {
    var reserveList = reserve.sorted().toMutableList()
    var lostList = lost.sorted().toMutableList()


    // lost & reserve 두 군데 포함된 경우 제외
    for (student in lost) {
        if (reserveList.contains(student)) {
            reserveList.remove(student)
            lostList.remove(student)
        }
    }

    for (student in lostList.toList()) {
        //앞 자리 친구가 있는 경우
        if (reserveList.contains(student - 1)) {
            reserveList.remove(student - 1)
            lostList.remove(student)
        }
        //뒷 자리 친구가 있는 경우
        else if (reserveList.contains(student + 1)) {
            reserveList.remove(student + 1)
            lostList.remove(student)
        }

    }

    return n - lostList.size
}

fun main() {
    println(
        solution42862(
            3,
            intArrayOf(3),
            intArrayOf(1)
        )
    )
}