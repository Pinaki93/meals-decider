package dev.pinaki.mealdecider.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.pinaki.mealdecider.data.local.database.entity.Category
import dev.pinaki.mealdecider.data.local.database.entity.Meal

/**
 * Base View Model for all our pages as of now
 */
class MealDeciderViewModel : ViewModel() {

    /*
    * Models we need:
    * 1. All Categories
    * 2. All meals
    * 3. Last selected category (From Shared Prefs)
    * 4.
    * */

    private val categories: MutableLiveData<List<Category>> by lazy {
        TODO("To implement repository layer")
    }

    private val meals: MutableLiveData<List<Meal>> by lazy {
        TODO("To implement repository layer")
    }

    private val lastSelectedCategory: MutableLiveData<Category?> by lazy {
        TODO("To implement repository layer")
    }

    private val randomMeal: MutableLiveData<Meal> by lazy {
        TODO("To implement repository layer")
    }

    fun getMeals(): LiveData<List<Meal>> {
        return meals
    }

    fun getCategories(): LiveData<List<Category>> {
        return categories
    }

    fun getLastSelectedCategory(): LiveData<Category?> {
        return lastSelectedCategory
    }

    fun getRandomMeal(): LiveData<Meal> {
        return randomMeal
    }

    fun addMeal(meal: Meal) {
        TODO("To implement repository layer")
    }

    fun addCategory(category: Category) {
        TODO("To implement repository layer")
    }

    fun generateRandomMeal(category: Category) {
        TODO("To implement repository layer")
    }


}