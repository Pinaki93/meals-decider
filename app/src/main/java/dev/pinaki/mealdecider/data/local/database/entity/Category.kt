package dev.pinaki.mealdecider.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "category")
data class Category(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") private var id: Long?,
    @ColumnInfo(name = "name") private val name: String,
    @ColumnInfo(name = "created_at") private val createdAt: Date = Date(),
    @ColumnInfo(name = "updated_at") private val updated_at: Date = Date()
)