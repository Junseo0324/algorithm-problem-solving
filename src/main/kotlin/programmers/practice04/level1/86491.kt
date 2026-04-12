package programmers.practice04.level1

fun solution86491(sizes: Array<IntArray>): Int {
    val list = sizes.map { it.sorted() }
    var width = 0
    var height = 0
    for (data in list) {
        width = maxOf(data[0], width)
        height = maxOf(data[1], height)
    }
    return width * height
}