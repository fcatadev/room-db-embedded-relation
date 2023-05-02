package com.fcadev.roomdbanotations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class User(
    @PrimaryKey val userId: Int,
    val name: String
)

@Entity
data class Pet(
    @PrimaryKey val petId: Int,
    val ownerId: Int,
    val name: String
)

data class UserWithPets(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "ownerId"
    )
    val pets: List<Pet>
)
