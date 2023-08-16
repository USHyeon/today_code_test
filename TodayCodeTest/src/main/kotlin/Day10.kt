fun main(args: Array<String>) {
    /**
     * solution01 : 문자열의 앞에서부터 n글자
     * 문제 설명
     * 문자열 my_string과 정수 n이 매개변수로 주어질 때, my_string의 앞의 n글자로 이루어진 문자열을 return 하는 solution 함수를 작성해 주세요.
     */
    fun solution01(my_string: String, n: Int): String {
        return my_string.substring(0, n)
    }

    println("solution01 : 문자열의 앞에서부터 n글자")
    println(solution01("ProgrammerS123", 11))
    println(solution01("He110W0r1d", 5))

    println()

    /**
     * solution02 : 접두사인지 확인하기
     * 문제 설명
     * 어떤 문자열에 대해서 접두사는 특정 인덱스까지의 문자열을 의미합니다. 예를 들어, "banana"의 모든 접두사는 "b", "ba", "ban", "bana", "banan", "banana"입니다.
     * 문자열 my_string과 is_prefix가 주어질 때, is_prefix가 my_string의 접두사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.
     */
    fun solution02(my_string: String, is_prefix: String): Int {
        return if (my_string.startsWith(is_prefix)) 1 else 0
    }

    println("solution02 : 접두사인지 확인하기")
    println(solution02("banana", "ban"))
    println(solution02("banana", "nan"))
    println(solution02("banana", "abcd"))
    println(solution02("banana", "bananan"))
}
