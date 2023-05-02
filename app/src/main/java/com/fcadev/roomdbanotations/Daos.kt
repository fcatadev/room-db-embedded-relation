package com.fcadev.roomdbanotations

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Transaction
    @Query("SELECT * FROM User WHERE userId = :userId")
    suspend fun getUserWithPets(userId: Int): UserWithPets
}

@Dao
interface PetDao {
    @Insert
    suspend fun insertPet(pet: Pet)
}
