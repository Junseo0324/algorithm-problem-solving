package BOJ.array_List

fun main() {
    var n = readln().toInt()
    var str = readln()
    var sum = 0
    str.forEach {
        sum += it.toString().toInt();
    }
    println(sum)
}