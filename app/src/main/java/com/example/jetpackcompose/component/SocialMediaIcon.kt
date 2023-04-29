package com.example.jetpackcompose.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R

@Composable
fun SocialMediaIcon(){
    Box(modifier = Modifier.size(58.dp).background(Color.Transparent),
    contentAlignment = Alignment.Center){
        Icon(
            painter = painterResource(id = R.drawable.google_icon),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.size(60.dp).padding(12.dp).clip(shape = RoundedCornerShape(12.dp)).border(width = 1.dp, color = MaterialTheme.colors.onSurface)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SocialMediaIconPreview(){
    SocialMediaIcon()
}