package pe.edu.upc.easysneaker.features.home.domain

data class Money(
    val amount: Double,
    val currency: String
) {
    init {
        require(amount >= 0) { "Amount must be greater than or equal to 0" }
        require(currency.isNotEmpty()) { "Currency must not be empty" }
    }
}

