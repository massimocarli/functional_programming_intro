package uk.co.maxcarli.fp

val incr = { a: Int -> a + 1 }
val square = { a: Int -> a * a }

fun adder(inc: Int): Func<Int, Int> = { x: Int ->
    x + inc
}

infix fun <A, B> A.into(f: Func<A, B>): B = f(this)

fun <A> identity(a: A) = a


fun throwsEx(): Nothing = throw Exception()

val comp1 = square after incr
val comp2 = incr compose square

fun never(): Nothing {
    while (true) {
    }
}

fun never(value: Nothing): Nothing = TODO()

fun unity1(a: Unit): Unit = Unit

fun unity2(): Unit = Unit


fun main() {
    3 into (comp1 compose ::println)

}