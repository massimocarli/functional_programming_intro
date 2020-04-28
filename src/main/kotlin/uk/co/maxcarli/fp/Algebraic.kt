package uk.co.maxcarli.fp

enum class Triage {
    RED,
    YELLOW,
    GREEN
}


fun main() {
    val triaged1 = Triage.RED to true
    val triaged2 = Triage.YELLOW to true
    val triaged3 = Triage.GREEN to true
    val triaged4 = Triage.RED to false
    val triaged5 = Triage.YELLOW to false
    val triaged6 = Triage.GREEN to false

    val atriaged1 = Triage.RED to Unit
    val atriaged2 = Triage.YELLOW to Unit
    val atriaged3 = Triage.GREEN to Unit

    // val ntriaged = Triage.GREEN to Nothing
}