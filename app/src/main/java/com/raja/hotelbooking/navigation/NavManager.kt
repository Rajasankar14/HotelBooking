package com.raja.jetpackcompose.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavManager @Inject constructor() {
    private  val  _route = MutableStateFlow(NavInfo())
    val route : StateFlow<NavInfo> = _route

    fun navigate(route : NavInfo?){
        _route.update { route ?: NavInfo() }
    }
}