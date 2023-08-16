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

    println()

    /**
     * solution03 : 문자열 뒤집기
     * 문제 설명
     * 문자열 my_string과 정수 s, e가 매개변수로 주어질 때, my_string에서 인덱스 s부터 인덱스 e까지를 뒤집은 문자열을 return 하는 solution 함수를 작성해 주세요.
     */
    fun solution03(my_string: String, s: Int, e: Int): String {
        my_string.substring(s, e + 1).also {
            return my_string.replace(it, it.reversed())
        }
    }

    println("solution03 : 문자열 뒤집기")
    println(solution03("Progra21Sremm3", 6, 12))
    println(solution03("Stanley1yelnatS", 4, 10))

    println()

    /**
     * solution04 : 세로 읽기
     * 문제 설명
     * 문자열 my_string과 두 정수 m, c가 주어집니다.
     * my_string을 한 줄에 m 글자씩 가로로 적었을 때 왼쪽부터 세로로 c번째 열에 적힌 글자들을 문자열로 return 하는 solution 함수를 작성해 주세요.
     */
    fun solution04(my_string: String, m: Int, c: Int): String {
        my_string.chunked(m).also { row ->
            return row.map { column ->
                column[c - 1]
            }.joinToString("")
        }
    }

    println("solution04 : 세로 읽기")
    println(solution04("ihrhbakrfpndopljhygc", 4, 2))
    println(solution04("programmers", 1, 1))
}