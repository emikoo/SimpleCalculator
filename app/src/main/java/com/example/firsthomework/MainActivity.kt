package com.example.firsthomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firsthomework.models.City
import kotlinx.android.synthetic.main.constraint_layout.*

class MainActivity : AppCompatActivity() {

    private var descriptionArray: List<City>? = null
    private var indexOfArray: Int? = null

    private var citiesArray = arrayOf(
        R.mipmap.ic_tokyo,
        R.mipmap.ic_fukuoka,
        R.mipmap.ic_kyoto,
        R.mipmap.ic_nagoya,
        R.mipmap.ic_osaka,
        R.mipmap.ic_sapporo,
        R.mipmap.ic_yokohama
    )

    private fun cityArray() {
        descriptionArray = listOf(
            City(0, "Токио", "Токио — столица и крупнейший мегаполис страны"),
            City(
                1, "Фукуока", "Крупнейшим мегаполисом на острове Кюсю является " +
                        "мегаполис Фукуока. Фукуока — это индустриальный город с развитой сферой услуг, логистический центр."
            ),
            City(
                2, "Киото", "Киото — древняя столица страны. В каждом районе города " +
                        "расположены многочисленные буддийские храмы и сионистские святилища."
            ),
            City(
                3, "Нагоя", "Еще один мегаполис страны — Нагоя. В городе развита " +
                        "металлургия, машиностроение, нефтехимическая промышленность."
            ),
            City(
                4,
                "Осака",
                "Осака находится на острове Хонсю и отличается портовым статусом. Тут развит культ еды."
            ),
            City(
                5, "Саппоро", "Крупнейшим японским городом острова Хоккайдо является " +
                        "Саппоро. Благодаря мягкому климату, Саппоро был выбран столицей Олимпиады зимних игр. Здесь " +
                        "находится один из лучших в мире центр для занятий горнолыжным спортом."
            ),
            City(
                6, "Йокогама", "Йокогама — второй по численности и важности мегаполис Японии. " +
                        "Сегодня это мощный экономический и промышленный центр."
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout)

        cityArray()
        changeIconAction()
    }

    private fun changeIconAction() {
        refresh_image_button.setOnClickListener {
            val citiesRandom = citiesArray.random()
            image.setImageResource(citiesRandom)

            getIndexFromElement(citiesRandom)
        }
    }

    private fun getIndexFromElement(element: Int) {
        for ((index, value) in citiesArray.withIndex()) {
            if (value == element) indexOfArray = index
            getDescriptionToImage(0)
            getDescriptionToImage(1)
            getDescriptionToImage(2)
            getDescriptionToImage(3)
            getDescriptionToImage(4)
            getDescriptionToImage(5)
            getDescriptionToImage(6)
        }
        return
    }

    private fun getDescriptionToImage(index: Int){
        if (indexOfArray == index) {
            city_name_text_view.text = descriptionArray?.get(index)?.name
            description_text_view.text = descriptionArray?.get(index)?.description
        }
        return
    }
}