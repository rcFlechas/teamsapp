package com.rcflechas.teamsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rcflechas.teamsapp.presentation.viewmodels.TeamsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val teamsViewModel: TeamsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        teamsViewModel.getByLeagueName("Spanish_La_Liga")
    }
}