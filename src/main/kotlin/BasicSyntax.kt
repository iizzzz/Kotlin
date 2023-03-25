class TestFunction {}

fun main(args: Array<String>) {
    printProduct("1", "2")
}

/* ----- 함수 정의 ----- */

// 함수 바디가 식(Expression)인 경우 reutrn문 생략가능, return Type이 추론됨
fun sum(a: Int, b: Int) = a+b

// Java의 void역할을 하는 리턴 타입이 없는 Unit(Object)이 있으며, Unit은 생략이 가능하다.
fun print1(): Unit { println("Kotlin") }
fun print2() { println("Kotlin") }



/* ----- 변수 정의 ----- */

fun Variable() {
    // val = Immutable 변수이며 읽기전용이고 선언시 초기화 필요.
    // (값 변경 불가능) Java의 final과 유사하다.
    val a: Int = 1
    val b = 2
    val c: Int // 컴파일 에러, 초기화 필요
    c = 3 // 컴파일 에러, 읽기 전용

    // var = Mutable 변수
    var x = 5
    x += 1
}



/* ----- 문자열 템플릿 ----- */

// String Interpolation (문자열 보간법)
fun StringTemplate() : String {
    var a = 1
    val s1 = "a is $a"

    a = 2
    var s2 = "${s1.replace("is", "was")}, but now is $a"

    return s2
}

/* ----- 조건문 ----- */

// 조건문을 조건 식으로 변환 가능
fun max1(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

// 조건 식(Expression)
fun max2(a: Int, b: Int) = if (a > b) a else b



/* ----- Nullable Type ----- */

// 값이 Null일 수 있는 경우 타입에 nullable을 '?' 기호를 사용해 명시
fun parseInt(str: String): Int? {
    // 정수가 아닌경우 null 리턴
    val value = str.toInt()
    return if (value !is Int) {
        null
    } else {
        value
    }
}

// Nullable 타입의 변수에 접근할 때 반드시 Null 체크를 해야함, 아니면 컴파일 에러 발생
fun printProduct(arg1: String, arg2: String) {
    val x: Int? = parseInt(arg1)
    val y: Int? = parseInt(arg2)


    println("either '$arg1' or '$arg2' is not a number")

}



/* ----- 자동 타입 변환 ----- */

// 타입 체크만 해도 자동으로 타입 변환, Any는 Object와 같은 의미이다
// obj가 스트링일때랑 length를 반환하며 String이 아니면 null 반환
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }
    return null
}



/* ----- Loop ----- */

// 자바와 거의 동일하다
fun loop() {
    val items = listOf("apple", "banana", "kiwi")
    var index = 0

    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

// When Expression
fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a String"
    else -> "Unknown"
    }

// Range - In 연산자를 이용해서 숫자 범위 체크
fun range() {
    val x = 3
    if (x in 1..10) {
        println("fits in range")
    }

    // range를 이용한 for loop
    for (x in 1..5) {
        print(x)
    }

    // 컬렉션 loop, 자바의 상향 for문과 비슷하다
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    // In 연산자로 해당 값이 컬렉션에 포함되는지 체크
    val items2 = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items2 -> println("juicy")
        "apple" in items2 -> println("apple is fine too")
    }

    // 람다식을 이용한 컬렉션의 filter, map 등 중간 연산
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }
}



/* ----- Array ----- */
fun arrayAndList() {
    val array : Array<Int> = arrayOf(1,2,3,4,5)
    val list : List<Int> = listOf(1,2,3,4,5)
    val arrayList : ArrayList<Int> = arrayListOf<Int>()

    array[0] = 3
    list[1]
    arrayList.add(20)
}