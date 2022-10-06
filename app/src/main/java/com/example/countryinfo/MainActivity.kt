package com.example.countryinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countryinfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val countryName = binding.countryNameEditText.text.toString()
            val countries = restCountriesApi.getCountryByName(countryName)
            val country = countries[0]

            binding.countryNameTextView.text = country.name
            binding.capitalTextView.text = country.capital
            binding.populationTextView.text = country.population.toString()
            binding.areaTextView.text = country.area.toString()
            binding.languagesTextView.text = country.languages.toString()
        }
    }
}