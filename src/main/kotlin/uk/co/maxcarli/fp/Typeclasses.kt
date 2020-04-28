package uk.co.maxcarli.fp

typealias ListFunctor<A, B> = ((A) -> B) -> (List<A>) -> List<B>
typealias OptionalFunctor<A, B> = ((A) -> B) -> (A?) -> B?

/**
 * The map() for an optional type
 */
fun <A, B> A?.map(fn: Func<A, B>): B? = if (this != null) fn(this) else null

fun main() {
    3.map(incr) into ::println
    null.map(incr) into ::println

    var left = listOf(1, 2, 3).map(incr).map(square)
    var right = listOf(1, 2, 3).map(incr compose square)
    (left == right) into ::println

    (3.map(incr).map(square) == 3.map(incr compose square)) into ::println

    left = listOf(1, 2, 3).map(incr).map(square)
    right = listOf(1, 2, 3).map(incr compose square)
    (left == right) into ::println

    (3.let(incr).let(square) == 3.let(incr compose square)) into ::println
}