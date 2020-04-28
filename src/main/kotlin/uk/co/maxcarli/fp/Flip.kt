package uk.co.maxcarli.fp

fun <A, B, C> Chain<A, B, C>.flip(): Chain<B, A, C> = { b: B ->
    { a: A ->
        this(a)(b)
    }
}

/**
 * Simplified version for avoiding dependency with Android
 */
class Handler {
    fun postDelayed(fn: Runnable, delay: Long): Boolean {
        Thread.sleep(delay)
        fn.run()
        return true
    }
}


fun main() {
    val handler = Handler()
    val runDelayed1Sec = handler::postDelayed.currying().flip()(1000L)
    runDelayed1Sec {
        // My TAsk
    }
}