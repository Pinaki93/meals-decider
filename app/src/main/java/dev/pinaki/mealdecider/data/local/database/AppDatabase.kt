package dev.pinaki.mealdecider.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.pinaki.mealdecider.data.local.database.converter.RoomDbConverter
import dev.pinaki.mealdecider.data.local.database.dao.CategoryDao
import dev.pinaki.mealdecider.data.local.database.dao.MealDao
import dev.pinaki.mealdecider.data.local.database.entity.Category
import dev.pinaki.mealdecider.data.local.database.entity.Meal

@Database(
    entities = [Meal::class, Category::class],
    version = 1
)
@TypeConverters(RoomDbConverter::class)
abstract class AppDatabase private constructor() : RoomDatabase() {

    abstract fun mealsDao(): MealDao

    abstract fun categoryDao(): CategoryDao


    companion object {
        private var instance: AppDatabase? = null

        const val DB_NAME = "meals-db"

        //TODO: Move this to Dependency Injection
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    if (instance == null)
                        synchronized(AppDatabase::class) {
                            Room
                                .databaseBuilder(context.applicationContext, AppDatabase::class.java, "meals-db")
                                .build()
                        }
                }
            }

            return instance!!
        }
    }
}