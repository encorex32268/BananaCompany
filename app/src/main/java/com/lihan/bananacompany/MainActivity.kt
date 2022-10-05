package com.lihan.bananacompany

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lihan.bananacompany.presentation.company.CompanyScreen
import com.lihan.bananacompany.ui.theme.BananaCompanyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BananaCompanyTheme {
                CompanyScreen()
            }
        }
    }
}
