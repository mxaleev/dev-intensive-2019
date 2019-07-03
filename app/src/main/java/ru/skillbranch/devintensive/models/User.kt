package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

class User (
    val id : String,
    var firstName : String?,
    var lastName : String?,
    var avatar : String?,
    var rating : Int = 0,
    var respect : Int = 0,
    val lastVisit : Date? = null,
    val isOnline : Boolean = false
) {

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id:String) : this(id, "John", "Doe")

    init {

        println("It's Alive!!! \n" +
                "${if(lastName==="Doe") "His name id $firstName $lastName" else "And his name is $firstName $lastName!!!" }\n")
    }

    companion object Factory{
        private var lastId : Int = -1
        fun makeUser(fullName:String?) : User{
            lastId++

//            var parts : List<String>? = fullName?.split(" ")
//
//            var firstName = parts?.getOrNull(0)
//            var lastName = parts?.getOrNull(1)

            val (firstName, lastName) = Utils.parseFullName(fullName)

            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }
    }

//    private fun getInto()="""
//        tu tu ru tuuuuuu !!!
//        tu tu ru tuuuuuuuuuu ...
//
//        tu tu ru tuuuuuu !!!
//        tu tu ru tuuuuuuuuuu ...
//        ${"\n\n\n"}
//        $firstName $lastName
//
//    """.trimIndent()
//
//    fun printMe():Unit{
//        println("""
//            id: $id
//            firstName: $firstName
//            lastName: $lastName
//            avatar: $avatar
//            rating: $rating
//            respect: $respect
//            lastVisit: $lastVisit
//            isOnline: $isOnline
//        """.trimIndent())
//    }

}