package BOJ.trytty

fun main() {

    val n = readln().toInt()

    var isFind = false
    fun backtrack(s: String) {
        if (isFind) return
        if (!isGood(s)) return

        if (s.length == n) {
            println(s)
            isFind = true
            return
        }

        for (i in '1'..'3') {
            backtrack(s+i)
        }
    }

    backtrack("")
}

fun isGood(str: String): Boolean {
    val len = str.length

    for (i in 1..(len/2)) {
        val back = str.substring(len-i,len)
        val front = str.substring(len-2*i,len-i)

        if (front == back) return false
    }

    return true
}