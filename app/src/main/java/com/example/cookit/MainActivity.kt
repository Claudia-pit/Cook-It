package com.example.cookit


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_recipes.*


class MainActivity : AppCompatActivity() {

    private lateinit var recipesFragment: RecipesFragment
    private lateinit var shopListFragment: ShopListFragment
    private lateinit var profileFragment: ProfileFragment



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.bottomNavigationView)



        recipesFragment = RecipesFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, recipesFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()




        bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when(item.itemId){

                R.id.bottomNavigationRecipesMenuId -> {
                    recipesFragment = RecipesFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, recipesFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.bottomNavigationShopListMenuId -> {
                    shopListFragment = ShopListFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, shopListFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.bottomNavigationProfileMenuId -> {
                    profileFragment = ProfileFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }


    }

}
