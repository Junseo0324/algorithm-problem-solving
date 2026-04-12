package programmers.practice04.level1

fun main() {
    println(solution118666(arrayOf("AN", "CF", "MJ", "RT", "NA"), intArrayOf(5, 3, 2, 7, 5)))
    println(solution118666(arrayOf("TR", "RT", "TR"), intArrayOf(7, 1, 3)))
}

// RT / CF / JM / AN
fun solution118666(survey: Array<String>, choices: IntArray): String {
    var answer = StringBuilder()
    val types = arrayOf("R","T","C","F","J","M","A","N")
    var hashMap = mutableMapOf<String,Int>()
    for(i in survey.indices) {
        if(choices[i] >=5) {
            hashMap[survey[i].substring(1)] = hashMap.getOrDefault(survey[i].substring(1),0)+choices[i]-4
        } else
            hashMap[survey[i].substring(0,1)] = hashMap.getOrDefault(survey[i].substring(0,1),0)+4-choices[i]
    }

    for(i in 0 until types.size step 2) {
        var type1 = types[i]
        var type2 = types[i+1]

        if(hashMap.getOrDefault(type1,0) > hashMap.getOrDefault(type2,0)) {
            answer.append(type1)
        } else if(hashMap.getOrDefault(type1,0) < hashMap.getOrDefault(type2,0)) {
            answer.append(type2)
        } else
            answer.append(type1)
    }
    return answer.toString()
}