package uk.co.maxcarli.fp

class ValidationException(msg: String) : Exception(msg)

fun validateName(name: String): Result<ValidationException, String> =
    if (name.length > 4) Success(name) else Error(ValidationException("Invalid Name"))

fun validateEmail(email: String): Result<ValidationException, String> =
    if (email.contains("@")) Success(email) else Error(ValidationException("Invalid email"))