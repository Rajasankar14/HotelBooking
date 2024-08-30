package com.raja.hotelbooking.MainHomeNavigation.viewModel

import androidx.lifecycle.ViewModel
import com.raja.jetpackcompose.navigation.NavManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainHomeNavViewModel @Inject constructor(val navManager: NavManager) : ViewModel() {
}