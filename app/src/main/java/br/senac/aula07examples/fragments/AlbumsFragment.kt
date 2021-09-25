package br.senac.aula07examples.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.senac.aula07examples.R

class AlbumsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    // Fabrica que constroi o fragmento
    companion object {
        @JvmStatic
        fun newInstance() = AlbumsFragment()
    }
}