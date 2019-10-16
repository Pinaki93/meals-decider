package dev.pinaki.mealdecider.data.local.database.dao

import androidx.room.*
import dev.pinaki.mealdecider.data.local.database.entity.Category

@Dao
interface CategoryDao {

    @Query("select * from category")
    suspend fun getAllCategories(): List<Category>

    @Insert
    suspend fun addCategory(category: Category)

    @Update
    suspend fun updateCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)
}