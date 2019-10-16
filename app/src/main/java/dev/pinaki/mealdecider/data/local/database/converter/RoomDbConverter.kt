package dev.pinaki.mealdecider.data.local.database.converter

import androidx.room.TypeConverter
import java.util.*


object RoomDbConverter {
    @TypeConverter
    fun timestampToDate(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}