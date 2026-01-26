package BOJ.implementation

fun main() {
    val T = readln().toInt()
    repeat(T) {
        val (r, str) = readln().split(" ")
        var answer = ""
        for (c in str) {
            val addStr = c.toString().repeat(r.toInt())
            answer += addStr
        }
        println(answer)
    }
}