package dev.pinaki.mealdecider.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "meal",
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = ["id"],
        childColumns = ["category_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Meal(
    @PrimaryKey @ColumnInfo(name = "id") private var id: Int?,
    @ColumnInfo(name = "name") private val name: String,
    @ColumnInfo(name = "category_id") private val categoryId: Int,
    @ColumnInfo(name = "created_at") private val createdAt: Date = Date(),
    @ColumnInfo(name = "updated_at") private val updated_at: Date = Date()
)