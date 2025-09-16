package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/92341

/**
 * fees = [기본 시간, 기본 요금, 단위 시간, 단위 요금]
 * records = [시각_차량번호_내역]
 * records.split(" ") -> 05:34 , 5961, IN => data ?
 */

fun solution92341(fees: IntArray, records: Array<String>): IntArray {
    fun toMinutes(time: String): Int {
        val (h,m) = time.split(":").map { it.toInt() }
        return h*60 + m
    }
    val inMap = mutableMapOf<String,Int>() // 차량 번호 -> 입차 시간
    val timeMap = mutableMapOf<String,Int>() // 차량번호, 누적 주차 시간

    for (record in records) { // 기록별 정리
        val data = record.split(" ")
        val time = toMinutes(data[0])
        if (data[2] == "IN") {
            inMap[data[1]] = time
        } else {
            val inTime = inMap.remove(data[1])!!
            timeMap[data[1]] = timeMap.getOrDefault(data[1],0) + (time - inTime)
        }
    }

    val endOfDay = toMinutes("23:59")
    for ((car, inTime) in inMap) {
        timeMap[car] = timeMap.getOrDefault(car, 0) + (endOfDay - inTime)
    }

    fun calcFee(time: Int): Int {
        if (time <= fees[0]) return fees[0]
        val extra = time - fees[0]
        val units = (extra + fees[2] -1) / fees[2]
        return fees[1] + units * fees[3]
    }

    return timeMap.toSortedMap().map { (_,time) -> calcFee(time) }.toIntArray()

}

fun main() {
    println(
        solution92341(
            intArrayOf(180, 5000, 10, 600),
            arrayOf("05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT")
        )
    )
}