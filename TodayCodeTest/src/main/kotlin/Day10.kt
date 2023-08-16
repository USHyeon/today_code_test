fun main(args: Array<String>) {
    /**
     * solution01 : 문자열의 앞에서부터 n글자
     * 문제 설명
     * 문자열 my_string과 정수 n이 매개변수로 주어질 때, my_string의 앞의 n글자로 이루어진 문자열을 return 하는 solution 함수를 작성해 주세요.
     */
    fun solution01(my_string: String, n: Int): String {
        return my_string.substring(0, n)
    }

    println("solution 01 : 문자열의 앞에서부터 n글자")
    println(solution01("ProgrammerS123", 11))
    println(solution01("He110W0r1d", 5))
}

/**
 * 문제 설명
 * 문자열 my_string과 정수 n이 매개변수로 주어질 때, my_string의 앞의 n글자로 이루어진 문자열을 return 하는 solution 함수를 작성해 주세요.
 */
fun solution01(my_string: String, n: Int): String {
    return my_string.substring(0, n)
}