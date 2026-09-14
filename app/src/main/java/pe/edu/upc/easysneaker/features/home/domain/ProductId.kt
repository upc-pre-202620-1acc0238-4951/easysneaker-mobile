package pe.edu.upc.easysneaker.features.home.domain

@JvmInline
value class ProductId(val value: Int) {
    init {
        require(value > 0) { "ProductId must be greater than 0" }
    }
}