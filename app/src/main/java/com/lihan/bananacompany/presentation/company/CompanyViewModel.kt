package com.lihan.bananacompany.presentation.company

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lihan.bananacompany.core.util.Resource
import com.lihan.bananacompany.domain.use_case.GetEmployees
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyViewModel @Inject constructor(
    private val getEmployees: GetEmployees
) : ViewModel() {

    var state by mutableStateOf(CompanyState())

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    sealed class UIEvent {
        data class ShowSnackbar(val message: String): UIEvent()
    }
    private var getDataJob : Job? = null

    init {
        getData()
    }

    private fun getData(){
        getDataJob?.cancel()
        getDataJob = viewModelScope.launch {
            getEmployees()
                .onEach {
                    when(it){
                        is Resource.Loading->{
                            state = state.copy(
                                employees = it.data?: emptyList(),
                                isLoading = true
                            )
                        }
                        is Resource.Success->{
                            state = state.copy(
                                employees = it.data?: emptyList(),
                                isLoading = false
                            )
                        }
                        is Resource.Error->{
                            state = state.copy(
                                employees = it.data?: emptyList(),
                                isLoading = false
                            )
                            _uiEvent.send(UIEvent.ShowSnackbar(it.message.toString()))
                        }
                    }
                }.launchIn(this)

        }

    }


}