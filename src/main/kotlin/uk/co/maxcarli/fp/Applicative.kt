package uk.co.maxcarli.fp

sealed class Result<out E, out A>
class Success<out A>(val a: A) : Result<Nothing, A>()
class Error<out E>(val e: E) : Result<E, Nothing>()

fun <E1, E2, T, R> Result<E1, T>.bimap(fe: (E1) -> E2, fs: (T) -> R): Result<E2, R> = when (this) {
    is Success<T> -> Success(fs(this.a))
    is Error<E1> -> Error(fe(this.e))
}

fun <E, T, R> Result<E, T>.mapRight(fn: (T) -> R): Result<E, R> = when (this) {
    is Success<T> -> Success(fn(this.a))
    is Error<E> -> this
}

fun <E1, E2, T> Result<E1, T>.mapLeft(fn: (E1) -> E2): Result<E2, T> = when (this) {
    is Success<T> -> this
    is Error<E1> -> Error(fn(this.e))
}


fun <T> just(value: T) = Success(value)


fun <E, T, R> Result<E, T>.ap(fn: Result<E, (T) -> R>): Result<E, R> = when (fn) {
    is Success<(T) -> R> -> mapRight(fn.a)
    is Error<E> -> when (this) {
        is Success<T> -> Error(fn.e)
        is Error<E> -> Error(this.e)
    }
}

data class User(val id: Int, val name: String, val email: String)

val userFactoryInternal = fun(id: Int, name: String, email: String): User = User(id, name, email)
val userFactory = userFactoryInternal.currying()

infix fun <E, A, B> Result<E, (A) -> B>.appl(a: Result<E, A>) = a.ap(this)


fun main() {
    val id = just(1)
    val name = just("Max")
    //val email = just("max@maxcarli.it")
    val email = Error(IllegalStateException("Invalid Email!"))
    val user = just(userFactory)

    (user appl id appl name appl email)
        .bimap({ println("Error: $it") }, { println("User: $it") })
}






