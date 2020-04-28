package uk.co.maxcarli.fp

sealed class Either<A, B>
class Left<A>(left: A) : Either<A, Nothing>()
class Right<B>(right: B) : Either<Nothing, B>()


fun main() {
    val triage1 = Left(Triage.RED)
    val triage2 = Left(Triage.RED)
    val triage3 = Left(Triage.RED)
    val triage4 = Right(Unit)
}

fun power1(b: Boolean) = when (b) {
    true -> Triage.RED
    false -> Triage.GREEN
}

fun power2(b: Boolean) = when (b) {
    true -> Triage.RED
    false -> Triage.YELLOW
}

fun power3(b: Boolean) = when (b) {
    true -> Triage.RED
    false -> Triage.RED
}

fun power4(b: Boolean) = when (b) {
    true -> Triage.YELLOW
    false -> Triage.GREEN
}

fun power5(b: Boolean) = when (b) {
    true -> Triage.YELLOW
    false -> Triage.YELLOW
}

fun power6(b: Boolean) = when (b) {
    true -> Triage.YELLOW
    false -> Triage.RED
}

fun power7(b: Boolean) = when (b) {
    true -> Triage.GREEN
    false -> Triage.GREEN
}

fun power8(b: Boolean) = when (b) {
    true -> Triage.GREEN
    false -> Triage.YELLOW
}

fun power9(b: Boolean) = when (b) {
    true -> Triage.GREEN
    false -> Triage.RED
}