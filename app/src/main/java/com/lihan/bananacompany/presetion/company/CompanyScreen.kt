package com.lihan.bananacompany.presetion.company

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CompanyScreen(
    viewModel : CompanyViewModel = hiltViewModel()
) {
    val result = viewModel.uiState.value
    when(result){
        is CompanyUiState.OnLoading->{
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is CompanyUiState.Success->{
            //show
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
             LazyColumn{
                 items(result.data){
                     EmployeeItem(employee = it)

                 }
             }
            }
        }
        is CompanyUiState.Fail->{
            Box (
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
                    ){
                Text(
                    text = "${result.message}",
                    style = MaterialTheme.typography.h1
                )
            }
        }
    }



}