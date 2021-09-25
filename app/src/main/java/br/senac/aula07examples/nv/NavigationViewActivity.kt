package br.senac.aula07examples.nv

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.senac.aula07examples.R
import br.senac.aula07examples.databinding.ActivityNvBinding
import br.senac.aula07examples.fragments.AlbumsFragment
import br.senac.aula07examples.fragments.ArtistsFragment
import br.senac.aula07examples.fragments.RecentsFragment

class NavigationViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityNvBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Ativando o icone do menu
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout,
            R.string.open_menu, R.string.close_menu)


        // Passando o toggle para o menu
        binding.drawerLayout.addDrawerListener(toggle)

        // Sicronizando o toggle
        toggle.syncState()

        //Adicionando o click do menu
        binding.navigation.setNavigationItemSelectedListener {

            binding.drawerLayout.closeDrawers()
            if(it.itemId == R.id.recentes){
                var frag = RecentsFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
            }
            /*
            when(it.itemId){

                R.id.recentes ->{
                    var frag = RecentsFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
                }
                R.id.albuns ->{
                    var frag = AlbumsFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
                }
                R.id.artistas ->{
                    var frag = ArtistsFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
                }
            }*/

            true
        }
    }

    // Sobrescrever para funcionar o menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item)
    }




}