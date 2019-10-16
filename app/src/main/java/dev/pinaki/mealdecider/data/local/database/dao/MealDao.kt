package dev.pinaki.mealdecider.data.local.database.dao

import androidx.room.*
import dev.pinaki.mealdecider.data.local.database.entity.Meal

@Dao
interface MealDao {

    @Query("select * from meal")
    suspend fun getAllMeals(): List<Meal>

    @Insert
    suspend fun addMeal(meal: Meal)

    @Update
    suspend fun updateMeal(meal: Meal)

    @Delete
    suspend fun deleteMeal(meal: Meal)
}