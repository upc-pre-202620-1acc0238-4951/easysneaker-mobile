package pe.edu.upc.easysneaker.features.home.infrastructure.local

import pe.edu.upc.easysneaker.features.home.domain.Product

/**
 * Assembler responsible for mapping local database entities [ProductEntity] 
 * into domain models [Product].
 */
object ProductEntityAssembler {

    /**
     * Converts a single [ProductEntity] into a domain [Product].
     * Returns null if the provided entity is null.
     */
    fun toDomainFromEntity(entity: ProductEntity?): Product? {
        if (entity == null) return null

        return Product(
            id = entity.id,
            name = entity.name,
            price = entity.price,
            rating = entity.rating,
            imageUrl = entity.image,
            description = entity.description,
            isFavorite = false
        )
    }

    /**
     * Converts a list of [ProductEntity] into a list of domain [Product].
     */
    fun toDomainList(entities: List<ProductEntity>): List<Product> {
        return entities.mapNotNull { toDomainFromEntity(it) }
    }
}