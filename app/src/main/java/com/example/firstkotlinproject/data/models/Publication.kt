package com.example.firstkotlinproject.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.firstkotlinproject.data.local.type.PublicationTypeConverter
import java.io.Serializable

@Entity(tableName = "publication")
@TypeConverters(PublicationTypeConverter::class)
data class Publication (
    @PrimaryKey(autoGenerate = false)
    var id: Int? = null,
    var image: String? = null,
    var name: String? = null,
    var phoneNumber: String? = null,
    var age: String? = null,
    var images: MutableList<Images>? = null,
    var randomImage: String? = null,
    var countOfLikes: Int = 0,
    var isFavorite: Boolean = true,
    var comment: MutableList<Comment>? = null
) : Serializable

val imageArray = mutableListOf<String>().apply {
    add("https://i1.sndcdn.com/artworks-twVuPijgKdMZwLOo-GAzEuQ-t500x500.jpg")
    add("https://i1.sndcdn.com/avatars-nwffhCdGSzMy9IY1-EruAgA-t240x240.jpg")
    add("https://i1.sndcdn.com/artworks-000204747428-j19cos-t500x500.jpg")
    add("https://e-talentbank.co.jp/wp-content/uploads/2019/08/6673c67b52df1a90ac381fba4f80ca84-1600x1600.png")
    add("https://static.wikia.nocookie.net/vocaloid/images/f/f4/Seeeeecun_icon.jpg/revision/latest?cb=20181222132429")
}

fun changeState(item: Publication) {
    if (item.isFavorite == item.isFavorite) {
        item.isFavorite = !item.isFavorite
    }
    if (item.isFavorite) item.countOfLikes += 1
    else item.countOfLikes -= 1
}

//fun getFavoriteArray() {
// mutableListOf<Publication>().apply {    addAll(publicationsArray.filter { it.isFavorite }) }
// }

//val publicationsArray = mutableListOf<Publication>().apply {
//    add(Publication(1,"https://64.media.tumblr.com/e8d9ed24c0202365ac2932e44574060b/tumblr_pz4kfjkDBN1xk7jd9o6_250.png","Tom", "999777222107", "80", imageArray, imageArray.random()))
//    add(Publication(2, "https://pbs.twimg.com/profile_images/1270819309309366272/5EC0nmb2.jpg", "Andrew", "999777222107", "30", imageArray, imageArray.random()))
//    add(Publication(3,"https://pm1.narvii.com/7018/ecccbcb2d36acab9d2f37293f3f0f9e3a4efc531r1-1200-1087v2_hq.jpg","Sara", "999777222107", "20", imageArray, imageArray.random()))
//    add(Publication(4,"https://i.pinimg.com/originals/ac/5c/94/ac5c94132860e7f32f601ebc4b3ffa80.jpg", "Mikel", "999777222107", "30", imageArray, imageArray.random()))
//    add(Publication(5,"https://i.ytimg.com/vi/u9DFW11nDR8/maxresdefault.jpg", "Kristian", "999777222107", "60", imageArray, imageArray.random()))
//    add(Publication(6,"https://i1.sndcdn.com/artworks-aqawqH0riHduHzKh-Ig6Oww-t500x500.jpg","Kate", "999777222107", "50", imageArray, imageArray.random()))
//    add(Publication(7, "https://i.ytimg.com/vi/HVDE0ergxv4/sddefault.jpg#404_is_fine","Jane", "999777222107", "40", imageArray, imageArray.random()))
//}

data class Images(
    var url: String? = null
)