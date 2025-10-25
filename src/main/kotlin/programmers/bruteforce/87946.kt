package programmers.bruteforce

// https://school.programmers.co.kr/learn/courses/30/lessons/87946?language=kotlin
/**
 * 일정 피로도를 사용해서 던전을 탐험할 수 있습니다.
 * 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"
 * 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"
 * "최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도
 * "소모 피로도"는 던전을 탐험한 후 소모되는 피로도
 *
 * 예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험
 * -> 유저의 현재 남은 피로도는 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 20이 소모됩니다.
 *
 * 이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데,
 * 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다.
 * 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도",
 * "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수
 * 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * k < 5000
 * dungeons < 8
 * dungeons [최소 필요 피로도, 소모 피로도]
 * 최소 필요 피로도" >= "소모 피로도"
 */

fun solution87946(k: Int, dungeons: Array<IntArray>): Int {
    var answer = 0
    val list = permutations(dungeons.indices.toList())
    list.forEach { data ->
        var remain = k
        var count = 0
        for (idx in data) {
            if (dungeons[idx][0] <= remain) {
                count++
                remain -= dungeons[idx][1]
            } else {
                break
            }
        }
        answer = Math.max(answer,count)

    }
    return answer
}

fun <T> permutations(list: List<T>): List<List<T>> {
    val result = mutableListOf<List<T>>()
    val visited = BooleanArray(list.size)

    fun dfs(path: MutableList<T>) {
        if (path.size == list.size) {
            result.add(path.toList())
            return
        }

        for (i in list.indices) {
            if (!visited[i]) {
                visited[i] = true
                path.add(list[i])
                dfs(path)
                path.removeAt(path.lastIndex)
                visited[i] = false
            }
        }
    }

    dfs(mutableListOf())
    return result
}

fun main() {
    println(solution87946(
        80,
        arrayOf(
            intArrayOf(80,20),
            intArrayOf(50,40),
            intArrayOf(30,10)
        )
    ))
}