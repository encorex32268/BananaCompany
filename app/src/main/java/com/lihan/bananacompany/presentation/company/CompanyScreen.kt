package com.lihan.bananacompany.presentation.company

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CompanyScreen(
    viewModel : CompanyViewModel = hiltViewModel()
) {

    val state = viewModel.state
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 =true){
        viewModel.uiEvent.collectLatest { event ->
            when(event){
                is CompanyViewModel.UIEvent.ShowSnackbar->{
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.message
                    )
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ){
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                items(state.employees) { employee ->
                    EmployeeItem(employee = employee)
                }
            }
            if (state.isLoading ){
                CircularProgressIndicator()
            }



        }

    }







}