package com.cesarsoftdevelopment.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.cesarsoftdevelopment.data.model.ProductEntity
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

    @Update
    suspend fun updateProduct(product: ProductEntity)

}