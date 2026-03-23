package BOJ.trytty

/**
 * 50 * 10000 500000
 */
fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val array = mutableListOf<String>()
        repeat(n) {
            array.add(readln())
        }

        array.sort()

        var answer = "YES"
        for (i in 0 until array.size-1) {
            if (array[i+1].startsWith(array[i])) {
                answer = "NO"
                break
            }
        }

        println(answer)

    }
}