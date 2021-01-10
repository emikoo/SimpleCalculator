package com.example.firsthomework.ui.contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firsthomework.R
import com.example.firsthomework.ui.contact_fragments.ContactFragment
import com.example.firsthomework.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    /*
    +Добавить 4 editText для EditProfileActivity()
    +со всех editText нужно получать значения и добавлять их в класс Actors
     */

    var contactFragment = ContactFragment()
    var profileFragment = ProfileFragment()
    var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragments()
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.contact -> navigateFragment(contactFragment)
                R.id.profile -> navigateFragment(profileFragment)
                else -> false
            }
        }
    }

    private  fun navigateFragment(fragment: Fragment) : Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, fragment).commit()
        return true
    }

    private fun addFragments(){
        supportFragmentManager.beginTransaction().add(R.id.container_fragment, contactFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.container_fragment, profileFragment).commit()
        flag = intent.getBooleanExtra("flag", false)
        if (flag) supportFragmentManager.beginTransaction().replace(R.id.container_fragment, profileFragment).commit()
        else supportFragmentManager.beginTransaction().replace(R.id.container_fragment, contactFragment).commit()
    }
}

