package uk.co.maxcarli.fp

val add = { a: Int, b: Int -> a + b }
val multi = { a: Int, b: Int -> a * b }


fun <A, B, C> Func2<A, B, C>.currying() = { a: A ->
    { b: B -> this(a, b) }
}

fun <A, B, C, D> Func3<A, B, C, D>.currying(): Chain3<A, B, C, D> = { a: A ->
    { b: B ->
        { c: C ->
            this(a, b, c)
        }
    }
}

fun <A, B, C> Chain<A, B, C>.uncurrying(): Func2<A, B, C> = { a: A, b: B ->
    this(a)(b)
}


fun main() {
    val f = 3 into add.currying() // Adds 3
    val g = 2 into add.currying() // Multiply by 2
    val add3AndMulti2 = f compose g
    3 into (add3AndMulti2 compose ::println)
}