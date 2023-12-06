package oop

import kotlin.random.Random

data class Task(
    val namaPenerima : String,
    val titleTask : String,
    val deadlineTanggal : String,
    val deadlineJam: String,
    val nameCreateTask : String
) {
    val imageURL = arrayOf("@drawable/img_4, @drawable/img_5, @drawable/img6")
    val random =  Random.nextInt(0, 3)
    val img = arrayOf(random)
}
