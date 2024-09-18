package com.cesarsoftdevelopment.omiesales.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cesarsoftdevelopment.omiesales.data.model.ProductEntity
import com.cesarsoftdevelopment.omiesales.data.model.Sale
import com.cesarsoftdevelopment.omiesales.domain.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(productEntity: ProductEntity): Long

    @Query("SELECT * FROM product")
    fun getAllProducts(): Flow<List<ProductEntity>>

    @Query("DELETE FROM product WHERE id = :productId")
    suspend fun deleteProductById(productId: Int)

    @Query("DELETE FROM product")
    suspend fun deleteAllProducts()

    @Query("UPDATE product SET quantity = :newQuantity WHERE id = :productId")
    suspend fun updateProductQuantity(productId: Int, newQuantity: Int)
}