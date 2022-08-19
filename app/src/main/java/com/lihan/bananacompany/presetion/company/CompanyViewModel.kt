package com.lihan.bananacompany.presetion.company

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lihan.bananacompany.domain.Result
import com.lihan.bananacompany.domain.use_case.GetEmployees
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyViewModel @Inject constructor(
    private val getEmployees: GetEmployees
) : ViewModel() {

    private val _uiState = mutableStateOf<CompanyUiState>(CompanyUiState.OnLoading)
    var uiState  = _uiState

    init {
        viewModelScope.launch {
            when(val result = getEmployees.invoke()){
                is Result.Success->{
                    _uiState.value = CompanyUiState.Success(result.data)
                }
                is Result.Fail->{
                    _uiState.value = CompanyUiState.Fail(result.message)
                }
            }
        }


    }




}