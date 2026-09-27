package pe.edu.upc.easysneaker.features.home.infrastructure.remote

import pe.edu.upc.easysneaker.features.home.infrastructure.local.ProductEntity

/**
 * Assembler responsible for mapping remote network DTOs ([ProductDto]) 
 * into local database entities [ProductEntity].
 */
object ProductDtoAssembler {

    /**
     * Converts a network [ProductDto] into a local [ProductEntity].
     */
    fun toEntity(dto: ProductDto): ProductEntity {
        return ProductEntity(
            id = dto.id,
            name = dto.name,
            price = dto.price,
            rating = dto.rating,
            image = dto.image,
            description = dto.description
        )
    }

    /**
     * Converts a list of network [ProductDto] objects into a list of [ProductEntity].
     */
    fun toEntityList(dtos: List<ProductDto>): List<ProductEntity> {
        return dtos.map { toEntity(it) }
    }
}