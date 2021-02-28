package org.fhmsyhdproject.pantiasuhanbanisalam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.fhmsyhdproject.pantiasuhanbanisalam.databinding.ActivityMainBinding
import org.fhmsyhdproject.pantiasuhanbanisalam.view.about.AboutFragment
import org.fhmsyhdproject.pantiasuhanbanisalam.view.donation.DonationFragment
import org.fhmsyhdproject.pantiasuhanbanisalam.view.home.HomeFragment
import org.fhmsyhdproject.pantiasuhanbanisalam.view.person.PersonFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentId: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnNavigationItemSelectedListener (mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        val fragmentCheck = fun(fragmentId: Int, fragment: Fragment) {
            if (currentId != fragmentId) {
                supportFragmentManager.beginTransaction().replace(R.id.home_frame, fragment).commit()
            }
        }

        when(it.itemId) {
            R.id.page_home -> fragmentCheck(R.id.page_home, HomeFragment())
            R.id.page_children -> fragmentCheck(R.id.page_children, PersonFragment())
            R.id.page_donation -> fragmentCheck(R.id.page_donation, DonationFragment())
            R.id.page_contact -> fragmentCheck(R.id.page_contact, PersonFragment())
            R.id.page_about -> fragmentCheck(R.id.page_about, AboutFragment())
        }

        currentId =it.itemId
        true
    }
}