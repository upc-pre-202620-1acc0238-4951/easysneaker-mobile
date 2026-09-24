package pe.edu.upc.easysneaker.features.home.infrastructure.local

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Query
import androidx.room3.Upsert

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    suspend fun fetchAllProducts(): List<ProductEntity>

    @Query("SELECT * FROM products where id = :id")
    suspend fun fetchProductById(id: Int): ProductEntity?

    @Upsert
    suspend fun insertProducts(entities: List<ProductEntity>)

    @Upsert
    suspend fun insertProduct(entity: ProductEntity)

    @Delete
    suspend fun deleteProduct(entity: ProductEntity)

}