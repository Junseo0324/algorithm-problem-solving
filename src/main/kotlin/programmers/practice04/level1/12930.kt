package programmers.practice04.level1

fun solution12930(s: String): String {
    return s.split(" ").joinToString(" ") {
        it.mapIndexed { index, s ->
            if (index % 2 == 0) s.uppercase() else s.lowercase()
        }.joinToString("")
    }

}