package uk.co.maxcarli.fp

typealias Func<A, B> = (A) -> B
typealias Func2<A, B, C> = (A, B) -> C
typealias Func3<A, B, C, D> = (A, B, C) -> D
typealias Chain<A, B, C> = (A) -> (B) -> C
typealias Chain3<A, B, C, D> = (A) -> (B) -> (C) -> D
typealias UserFactory = (id: Int, name: String, email: String) -> User

typealias TriageEither = Either<Triage, Boolean>
typealias TriageUnit = Either<Triage, Unit>

typealias Triaged = Pair<Triage, Boolean>
typealias AliasTriaged = Pair<Triage, Unit>
typealias TriagedNever = Pair<Triage, Nothing>

typealias Callback<Data, Result, Error> = (Data?, Result?, Error?) -> Unit

typealias Power = (Boolean) -> Triage

