package com.fcadev.roomdbanotations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AppDatabase.getDatabase(this)
        //this.deleteDatabase("app_database")

        insertSampleData()
        displayUserWithPets()
    }

    private fun insertSampleData() {
        val user = User(userId = 1, name = "Fatih Can")
        val user2 = User(userId = 2, name = "Geralt of Rivia")
        val user3 = User(userId = 3, name = "Harry Potter")
        db.userDao().insertUser(user)
        db.userDao().insertUser(user2)
        db.userDao().insertUser(user3)

        val pet1 = Pet(petId = 1, ownerId = 1, name = "Mayonez")
        val pet2 = Pet(petId = 2, ownerId = 2, name = "Roach")
        val pet3 = Pet(petId = 3, ownerId = 3, name = "Hedwig")
        db.petDao().insertPet(pet1)
        db.petDao().insertPet(pet2)
        db.petDao().insertPet(pet3)
    }

    private fun displayUserWithPets() {
        val userWithPets = db.userDao().getUserWithPets(1)
        Log.d("MainActivity", "User: ${userWithPets.user.name}")
        userWithPets.pets.forEach { pet ->
            Log.d("MainActivity", "Pet: ${pet.name}")
        }

        val userWithPets2 = db.userDao().getUserWithPets(2)
        Log.d("MainActivity", "User: ${userWithPets2.user.name}")
        userWithPets2.pets.forEach { pet ->
            Log.d("MainActivity", "Pet: ${pet.name}")
        }

        val userWithPets3 = db.userDao().getUserWithPets(3)
        Log.d("MainActivity", "User: ${userWithPets3.user.name}")
        userWithPets3.pets.forEach { pet ->
            Log.d("MainActivity", "Pet: ${pet.name}")
        }
    }
}
