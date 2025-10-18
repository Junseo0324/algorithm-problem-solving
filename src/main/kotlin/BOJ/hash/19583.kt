package BOJ.hash

fun main() {
    val (start,end,quit) = readln().split(" ")
    val startSet = mutableSetOf<String>()
    val endSet = mutableSetOf<String>()
    while (true) {
        val data = readlnOrNull() ?: break
        if (data.isEmpty()) break
        val (time,name) = data.split(" ")
        if (parseMinute(time) <= parseMinute(start)) {
            startSet.add(name)
        }
        if (parseMinute(time) >= parseMinute(end) && parseMinute(time) <= parseMinute(quit)) {
            endSet.add(name)
        }
    }
    println(startSet.intersect(endSet).size)
}
fun parseMinute(time: String): Int {
    val (hour,min) = time.split(":").map { it.toInt() }
    return hour*60 + min
}