package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/160586

fun solution160586(keymap: Array<String>, targets: Array<String>): IntArray {
    var result: IntArray = intArrayOf()
    for (i in targets.indices) {
        var arr = targets[i].toCharArray()
        var count = 0
        for (j in arr.indices){
            var min = 101
            var isCheck = false
            for (k in keymap.indices){
                if (keymap[k].contains(arr[j])) {
                    min = Math.min(min,keymap[k].indexOf(arr[j])+1)
                    isCheck = true
                }
            }
            if (isCheck) {
                count+=min
            } else {
                count+= 100000
            }
        }

        if (count >=100000) {
            result +=-1
        } else {
            result += count
        }
    }
    println(result.joinToString(","))
    return result

}

fun main() {
    solution160586(arrayOf("ABACD","BCEFD"), arrayOf("ABCD","AABB"))
}