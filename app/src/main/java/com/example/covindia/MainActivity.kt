package com.example.covindia
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.covindia.fragments.AboutFragment
import com.example.covindia.fragments.DiscoverFragment
import com.example.covindia.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val homeFragment = HomeFragment()
        val discoverFragment = DiscoverFragment()
        val aboutFragment = AboutFragment()

        makeCurrentFragment(homeFragment)

        btm_navigation_bar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_discover -> makeCurrentFragment(discoverFragment)
                R.id.ic_about -> makeCurrentFragment(aboutFragment)

            }
            true
        }

    }



    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()

        }

}



