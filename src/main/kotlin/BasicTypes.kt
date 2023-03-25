class BasicTypes {}

fun main() {
    특별한배열()
    문자열()
}

fun 숫자형() {
    /*
    - 자바 플랫폼을 사용할 경우 숫자형은 JVM Primitive Type으로 저장된다.
    - Nullable이나 Generic의 경우에는 Boxing 되어 Object로 사용된다.
    - Boxing된 경우, Identity를 유지하지 않는다.
    - '==='는 equals와 같은 의미이다
     */

    // JVM Primitive
    var a: Int = 100
    print(a === a) // Prints True

    // Boxed
    var boxedA: Int? = a
    var anotherBoxedA: Int? = a
    println("==: ${boxedA == anotherBoxedA}") // Prints True
    println("===: ${boxedA === anotherBoxedA}") // Prints True
}


fun 문자(c: Char): Any {
    /*
     - Char는 숫자로 취급되지 않는다.
     - if 조건문 안의 '1'을 숫자 1로 바꾸면 컴파일 자체가 안된다.
     */

    return if (c is Char) {
        c
    } else {
        print("숫자가 아닙니다")
    }
}


fun 문자열() {
    /*
    - 문자열은 String 클래스로 표현
    - String은 Character로 구성된다.
    - 그러므로 s[i]와 같은 방식으로 접근이 가능하다. (Immutable 이므로 변경 불가)
     */

    var x: String = "Kotlin"
    println(x.get(0))
    println(x[0])
    println(x.length)

    for (c in x) {
        println(c)
    }
}


fun Literal_언더스코어() {
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
}


fun Explicit_Conversions() {
    /*
    - 작은 타입은 큰 타입의 하위 타입이 아니다.
    - 작은 타입에서 큰 타입으로의 대입이 안되고 명시적으로 변환을 해주어야 한다.
    - to + [ Byte | Short | Int | Long | Float | Double | Char ]로 명시적 형변환을 하자.
     */

    val a: Int = 1 // A boxed Int
//    val b: Long = a // 오류

    val b: Long = a.toLong()
//    println(a == b) // 오류

    val i: Int = b.toInt() // OK, 명시적 형변환을 해주어야 함
}


fun 배열() {
    /* 배열 생성
    - Array의 팩토리 함수 OR arrayOf() 등의 라이브러리 함수를 사용해 생성한다.
     */

    // 팩토리 함수 사용하여 배열 생성
    var array1 = Array(5, { i -> i.toString()})
    for (output in array1) {
        print(output)
    }

    // Of 라이브러리 함수 사용하여 배열 생성
    val array2 : Array<Int> = arrayOf(1,2,3,4,5)
    for (output in array2) {
        print(output)
    }

    val list : List<Int> = listOf(1,2,3,4,5)
    val arrayList : ArrayList<Int> = arrayListOf<Int>()

    array2[0] = 3
    list[1]
    arrayList.add(20)
}


fun 특별한배열() {
    /*
    - Primitive 타읍의 박싱 오버헤드를 없애기 위한 배열
    - IntArray, ShortArray, IntArray
    - Array를 상속한 클래스들은 아니지만, Array와 같은 메서드와 프로퍼티를 가짐
    - size 등 유용한 멤버 함수를 포함한다
     */

    val x: IntArray = intArrayOf(1,2,3)
    x[0] = 7
    println(x.get(0))
    println(x[0])
    println(x.size)
}