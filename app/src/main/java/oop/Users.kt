package oop
class Users(val fullName : String?, val email : String?, val password : String?) {
    constructor(email: String?) : this ("fullName", email, "password")
}

