package pe.edu.upc.easysneaker.features.home.infrastructure.local

import androidx.room3.Dao
import androidx.room3.Query

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    suspend fun fetchAllProducts(): List<ProductEntity>
}