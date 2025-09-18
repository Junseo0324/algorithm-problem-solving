package programmers.level_2

// https://school.programmers.co.kr/learn/courses/30/lessons/42888

/**
 *
 * 누군가 들어오면 [닉네임]님이 들어왔습니다 / [낙네임]님이 나갔습니다.
 * 채팅방에서 닉네임을 변경하는 방법
 * 1. 채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다
 * 2. 채팅방에서 닉네임을 변경
 *
 */
fun solution42888(record: Array<String>): Array<String> {
    var answer = arrayOf<String>()
    val nickNameHm = mutableMapOf<String,String>() //uid + nickname
    val recordList = mutableListOf<Pair<String,String>>() // Enter or Leave / uid

    record.forEach {
        val data = it.split(" ")
        val status = data[0]
        val uid = data[1]
        val nickname = if (data.size > 2) data[2] else ""
        if (nickname.isNotEmpty()) {
            nickNameHm[uid] = nickname
        }
        recordList.add(Pair(status,uid))
    }

    recordList.forEach {
        val status = it.first
        val uid = it.second

        if (status == "Enter") {
            answer += "${nickNameHm[uid]}님이 들어왔습니다."
        } else if (status == "Leave"){
            answer += "${nickNameHm[uid]}님이 나갔습니다."
        }
    }

    return answer
}

fun main() {
    println(
        solution42888(
            arrayOf(
                "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
            )
        )
    )
}