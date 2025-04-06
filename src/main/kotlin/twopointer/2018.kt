package twopointer

fun main() {
    var n = readln().toInt()

    var start = 1
    var end = 1
    var sum = 1
    var count = 1
    while (end !=n)  {
        if (sum == n) {
            count++
            end++
            sum +=end
        }else if (sum > n) {
            sum -= start
            start++
        } else {
            end++
            sum += end
        }
    }

    println(count)
}
