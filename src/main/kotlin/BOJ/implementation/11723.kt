package BOJ.implementation

fun main() = with(System.`in`.bufferedReader()){
    val s = mutableSetOf<Int>()
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val input = readLine().split(" ")
        val action = input[0]
        val num = if (input.size > 1) input[1].toInt() else 0
        when(action) {
            "add" -> s.add(num)
            "remove" -> if (s.contains(num)) s.remove(num)
            "check" -> sb.append(if (s.contains(num)) 1 else 0).append('\n')
            "toggle" -> if (s.contains(num)) s.remove(num) else s.add(num)
            "all" -> {
                s.clear()
                s.addAll(1..20)
            }
            "empty" -> s.clear()
        }
    }
    print(sb)
}