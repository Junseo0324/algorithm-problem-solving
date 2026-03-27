package programmers.practice.pq

import java.util.PriorityQueue

/**
 * 어떤 작업 요청이 들어왔을 때 작업의 번호, 작업의 요청 시각, 작업의 소요 시간을 저장해 두는 대기 큐가 있습니다. 처음에 이 큐는 비어있습니다.
 * 디스크 컨트롤러는 하드디스크가 작업을 하고 있지 않고 대기 큐가 비어있지 않다면 가장 우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 그 작업을 시킵니다.
 * 이때, 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위가 높습니다.
 * 하드디스크는 작업을 한 번 시작하면 작업을 마칠 때까지 그 작업만 수행합니다.
 * 하드디스크가 어떤 작업을 마치는 시점과 다른 작업 요청이 들어오는 시점이 겹친다면
 *      하드디스크가 작업을 마치자마자 디스크 컨트롤러는 요청이 들어온 작업을 대기 큐에 저장한 뒤
 *      우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 그 작업을 시킵니다.
 * 또, 하드디스크가 어떤 작업을 마치는 시점에 다른 작업이 들어오지 않더라도
 * 그 작업을 마치자마자 또 다른 작업을 시작할 수 있습니다.
 */
fun main() {
    println(
        solution42627(
            jobs = arrayOf(
                intArrayOf(0, 3), // 요청, 소요 시간
                intArrayOf(1, 9),
                intArrayOf(3, 5),
            )
        )
    )
}

fun solution42627(jobs: Array<IntArray>): Int {
    var answer = 0
    val waitPq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first }) // 요청 시간 순서대로
    val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second }) // 소요 시간 순서대로 저장
    waitPq.addAll(jobs.map { it[0] to it[1] })
    var time = 0

    println(waitPq)
    while (waitPq.isNotEmpty() || pq.isNotEmpty()) {
        while (waitPq.isNotEmpty() && waitPq.peek().first <= time) {
            pq.add(waitPq.poll())
        }
        if (pq.isNotEmpty()) {
            val (requestTime, workTime) = pq.poll()
            time += workTime
            answer += time - requestTime
            println("time: $time, answer: $answer")
        } else if (waitPq.isNotEmpty()) {
            time = waitPq.peek().first
        }
    }
    return answer / jobs.size
}