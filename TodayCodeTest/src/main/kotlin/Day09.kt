fun main(args: Array<String>) {
    println("Solution 01")
    println(solution01(arrayOf("0123456789", "9876543210", "9999999999999"), 50000, 5, 5).toList())

    println("Solution 02")
    println(
        solution02(
            arrayOf("progressive", "hamburger", "hammer", "ahocorasick"),
            arrayOf(intArrayOf(0, 4), intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(7, 7))
        )
    )
}

/**
 * 문제 설명
 * 문자열 배열 intStrs와 정수 k, s, l가 주어집니다. intStrs의 원소는 숫자로 이루어져 있습니다.
 * 배열 intStrs의 각 원소마다 s번 인덱스에서 시작하는 길이 l짜리 부분 문자열을 잘라내 정수로 변환합니다.
 * 이때 변환한 정수값이 k보다 큰 값들을 담은 배열을 return 하는 solution 함수를 완성해 주세요.
 */
fun solution01(intStrs: Array<String>, k: Int, s: Int, l: Int): IntArray {
    return intStrs.mapNotNull {
        it.substring(s, s + l).toIntOrNull()
    }.filter {
        it > k
    }.toIntArray()
}

/**
 * 문제 설명
 * 길이가 같은 문자열 배열 my_strings와 이차원 정수 배열 parts가 매개변수로 주어집니다. parts[i]는 [s, e] 형태로,
 * my_string[i]의 인덱스 s부터 인덱스 e까지의 부분 문자열을 의미합니다. 각 my_strings의 원소의 parts에 해당하는 부분 문자열을
 * 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.
 */
fun solution02(myStrings: Array<String>, parts: Array<IntArray>): String {
    return parts.mapIndexed { index, (s, e) ->
        myStrings[index].substring(s, e + 1)
    }.joinToString("")
}