package com.example.app1.vaccines

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.app1.R
import com.example.app1.databinding.FragmentVaccinesBinding

class VaccinesFragment : Fragment() {

    private lateinit var vaccinesViewModel: VaccinesViewModel
    private var _binding: FragmentVaccinesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vaccinesViewModel =
            ViewModelProvider(this).get(VaccinesViewModel::class.java)

        _binding = FragmentVaccinesBinding.inflate(inflater, container, false)

        binding.cardView1.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_navigation_home_to_covaxinData);
        }


        val root: View = binding.root

        setHasOptionsMenu(true)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }
}