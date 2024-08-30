package com.raja.jetpackcompose.splash

import androidx.lifecycle.ViewModel
import com.raja.jetpackcompose.navigation.NavManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel  @Inject constructor(val navManager: NavManager) : ViewModel(){
}