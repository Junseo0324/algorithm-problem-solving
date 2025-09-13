package programmers.level_2


// https://school.programmers.co.kr/learn/courses/30/lessons/42586?language=kotlin

/**
 * progresses.length <= 100
 * 배포 하루 1회,
 * ex) 95% 인 개발의 하루 속도가 4%라면 2일 후
 *
 * 앞에 있는 기능보다 뒤에가 먼저 끝날 수 있지만 앞이 100이 되어야 뒷 기능이 같이 배포 가능!
 */
fun solution42586(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = intArrayOf()
    var progressesList = progresses.toMutableList()
    val speedsList = speeds.toMutableList()


    while (progressesList.isNotEmpty()) {
        for (i in progressesList.indices) {
            progressesList[i] += speedsList[i]
        }

        var count = 0

        while (progressesList.isNotEmpty() && progressesList[0] >= 100) {
            progressesList.removeAt(0)
            speedsList.removeAt(0)
            count += 1
        }
        if (count > 0) {
            answer += count
        }
    }

    return answer
}

fun main() {
    println(
        solution42586(
            intArrayOf(93, 30, 55),
            intArrayOf(1, 30, 5)
        )
    )
}