package com.lihan.bananacompany.presentation.company

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lihan.bananacompany.R
import com.lihan.bananacompany.domain.model.Employee

@Composable
fun EmployeeItem(
    employee: Employee,
    modifier: Modifier = Modifier,
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
        ,
        verticalAlignment = Alignment.CenterVertically
        ){

        Row{
           Image(
               modifier = Modifier.size(80.dp),
               painter = if (employee.gender == "female")
                   painterResource(id = getFemaleImages()) else
                   painterResource(id = getMaleImages()),
               contentDescription = "gender"
           )
           Image(
               modifier = Modifier
                   .size(20.dp)
                   .offset(x = (-10).dp)
                   .align(Alignment.Bottom)
                   .alignBy(LastBaseline),
               painter = if (employee.isActive)
                       painterResource(id = R.drawable.ic_acitve_true) else
                       painterResource(id = R.drawable.ic_active_false)
               ,
               contentDescription = "active")
        }
        Spacer(modifier = Modifier.width(4.dp))
        Column (
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "Name : ${employee.name}",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = "Phone : ${employee.phone}",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = "Email : ${employee.email}",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(1.dp))
//            Text(
//                text = "Address : ${employee.address}",
//                style = MaterialTheme.typography.body1
//            )
        }


    }




}

fun getFemaleImages()=listOf(
    R.drawable.avatar_woman_1,
    R.drawable.avatar_woman_2,
    R.drawable.avatar_woman_3,
    R.drawable.avatar_woman_4,
    R.drawable.avatar_woman_5,
    R.drawable.avatar_woman_6,
    R.drawable.avatar_woman_7,
    R.drawable.avatar_woman_8,
    R.drawable.avatar_woman_9,
    R.drawable.avatar_woman_10,
).random()

fun getMaleImages()= listOf(
        R.drawable.avatar_man_1,
        R.drawable.avatar_man_2,
        R.drawable.avatar_man_3,
        R.drawable.avatar_man_4,
        R.drawable.avatar_man_5,
        R.drawable.avatar_man_6,
        R.drawable.avatar_man_7,
        R.drawable.avatar_man_8,
        R.drawable.avatar_man_9,
        R.drawable.avatar_man_10,
    ).random()

