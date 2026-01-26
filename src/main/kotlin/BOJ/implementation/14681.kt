package BOJ.implementation

fun main() {
    val x = readln().toInt()
    val y = readln().toInt()

    // true 양 , false 음
    val isX = x > 0
    val isY = y > 0

    if (isX) {
        if (isY) println(1) else println(4)
    } else {
        if (isY) println(2) else println(3)
    }

}