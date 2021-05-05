package com.jones.honorsmobileapps.networkingdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.jones.honorsmobileapps.networkingdemo.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: EarthquakeViewModel by viewModels()

    val earthquakes: List<Earthquake> = listOf(
            Earthquake(1.29, "10km SSW of Idyllwild, CA", 1388620296020),
            Earthquake(1.1, "117km NW of Talkeentna, Alaska", 1388620046501))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        val mAdapter = EarthquakeAdapter(earthquakes)
        binding.recyclerView.adapter = mAdapter

        viewModel.getEarthquakes()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}