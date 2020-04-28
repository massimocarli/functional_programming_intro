package uk.co.maxcarli.fp

infix fun <A, B, C> Func<A, B>.compose(g: Func<B, C>): Func<A, C> = { a: A ->
    g(this(a))
}

infix fun <A, B, C> Func<B, C>.after(f: Func<A, B>): Func<A, C> = { a: A ->
    this(f(a))
}

object Logger {
    val buffer = StringBuilder()
    fun log(msg: String) {
        buffer.append("$msg \n")
    }

    fun flush() {
        println(buffer.toString())
        buffer.clear()
    }
}

/*
fun squareAndLog(a: Int): Pair<Int, String> =
    a * a to "Square of $a is ${a * a}"

fun incrAndLog(a: Int): Pair<Int, String> =
    a + 1 to "Incr of $a is ${a + 1}"

 */


//val loggedComp = ::squareAndLog compose ::incrAndLog

typealias Writer<A, B> = Func<A, Pair<B, String>>

val squareAndLog: Writer<Int, Int> =
    { a: Int -> a * a to "Square of $a is ${a * a}" }
val incrAndLog: Writer<Int, Int> =
    { a: Int -> a + 1 to "Incr of $a is ${a + 1}" }

@JvmName("composeWriter")
infix fun <A, B, C> Writer<A, B>.compose(f: Writer<B, C>): Writer<A, C> =
    { x: A ->
        val p1 = this(x)
        val p2 = f(p1.first)
        p2.first to p1.second + "\n" + p2.second
    }

val loggedComp = squareAndLog compose incrAndLog

fun <A, B> first(p: Pair<A, B>): A = p.first
fun <A, B> second(p: Pair<A, B>): B = p.second

fun main() {
    3 into loggedComp into ::println
    3 into (loggedComp compose ::second compose ::println)
}