package com.eritlab.jexmon.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eritlab.jexmon.presentation.Screen
import com.eritlab.jexmon.presentation.ui.theme.RedOrange

@Composable
fun CustomDefaultBtn(
    btnText: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)
            .height(55.dp)
            .clip(RoundedCornerShape(20.dp)),
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.RedOrange,
            contentColor = Color.White
        ),
    ) {
        Text(text = btnText, fontSize = 16.sp)
    }
}