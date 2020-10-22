package com.example.firsthomework

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.constraint_layout.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val citiesArray = arrayOf(R.mipmap.ic_tokyo, R.mipmap.ic_fukuoka, R.mipmap.ic_kyoto,
        R.mipmap.ic_nagoya, R.mipmap.ic_osaka, R.mipmap.ic_sapporo, R.mipmap.ic_yokohama)

    var indexOfArray: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout)

        changeIconAction()
    }

    private fun changeIconAction() {
        refresh_image_button.setOnClickListener {
            val citiesRandom = citiesArray.random()
            image.setImageResource(citiesRandom)

            for((index, value) in citiesArray.withIndex()) {
                if (value == citiesRandom){
                    indexOfArray = index
                }
            }
            showDescription(0, "Токио", "Токио — столица и крупнейший мегаполис страны")
            showDescription(1,"Фукуока", "Крупнейшим мегаполисом на острове Кюсю является " +
                        "мегаполис Фукуока. Фукуока — это индустриальный город с развитой " +
                        "сферой услуг, логистический центр.")
            showDescription(2,"Киото", "Киото — древняя столица страны. В каждом районе города " +
                        "расположены многочисленные буддийские храмы и сионистские святилища.")
            showDescription(3,"Нагоя", "Еще один мегаполис страны — Нагоя. В городе развита " +
                        "металлургия, машиностроение, нефтехимическая промышленность.")
            showDescription(4,"Осака", "Осака находится на острове Хонсю и отличается портовым " +
                        "статусом. Тут развит культ еды.")
            showDescription(5,"Саппоро", "Крупнейшим японским городом острова Хоккайдо является " +
                        "Саппоро. Благодаря мягкому климату, Саппоро был выбран столицей " +
                        "Олимпиады зимних игр. Здесь находится один из лучших в мире центр для " +
                        "занятий горнолыжным спортом.")
            showDescription(6,"Йокогама", "Йокогама — второй по численности и важности мегаполис" +
                        " Японии. Сегодня это мощный экономический и промышленный центр.")
        }
    }

    private fun showDescription(i: Int, name: String, value: String){
        if(indexOfArray == i) {
            city_name_text_view.text = name
            description_text_view.text = value
            return
        }
    }
}