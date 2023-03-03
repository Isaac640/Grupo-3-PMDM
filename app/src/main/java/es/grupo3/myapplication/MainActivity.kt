package es.grupo3.myapplication

import LoginStorageHelper
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import es.grupo3.myapplication.data.Repository
import es.grupo3.myapplication.databinding.ActivityMainBinding
import es.grupo3.myapplication.viewmodel.ViewModel
import kotlinx.coroutines.launch
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val res: Resources = resources
        res.configuration.setLocale(Locale("es"))
        res.updateConfiguration(res.configuration, res.displayMetrics)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.layoutFragmentHolder) as NavHostFragment
        navController = navHostFragment.navController

        val loginData: List<String> = LoginStorageHelper(this).getLogin()
        if (loginData.isEmpty()) {
            setContentView(binding.root)
            return
        }

        lifecycleScope.launch{
            val id: Int = Repository().iniciarSesion(loginData[0], loginData[1])

            if (id == 0) {
                setContentView(binding.root)
                return@launch
            }

            viewModel.profesor = Repository().getProfesor(id)
        }

        setContentView(binding.root)
        navController.navigate(R.id.fragmentInicio)
    }
}