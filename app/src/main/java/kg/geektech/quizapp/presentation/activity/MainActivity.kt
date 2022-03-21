package kg.geektech.quizapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import kg.geektech.quizapp.R
import kg.geektech.quizapp.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavController()    }

    private fun initNavController() {
        navController = Navigation.findNavController(this,R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(binding.bottomNavigation,navController)

        navController.addOnDestinationChangedListener{_,destination,_ ->
            binding.bottomNavigation.isVisible = destination.id==R.id.mainFragment ||
                    destination.id==R.id.historyFragment ||
                    destination.id==R.id.settingsFragment
        }
    }
}