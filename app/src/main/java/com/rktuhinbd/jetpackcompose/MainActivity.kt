package com.rktuhinbd.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rktuhinbd.jetpackcompose.ui.theme.JetpackComposeTheme
import com.rktuhinbd.jetpackcompose.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun ListView(userDataList: MutableList<Data>) {
    LazyColumn {
        items(userDataList) { data ->
            DataView(name = data.name, data.phone)
        }
    }
}

@Composable
fun MainContent() {
    var id = 1
    val data = Data(id, "Md Rejaul Karim", "01841752600")
    val dataList = remember {
        mutableStateListOf(data)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        ListView(dataList)
        Button(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomCenter),
            onClick = {
                id++
                dataList.add(Data(id, "Md Rejaul Karim", "01841752600"))
            }) {
            Text(text = "Add More")
            Shapes.medium
        }
    }
}

//val users = mutableListOf(
//    Data(1, "Md Rejaul Karim", "01841752600"),
//    Data(2, "Md Rejaul Karim", "01841752600"),
//    Data(3, "Md Rejaul Karim", "01841752600"),
//    Data(4, "Md Rejaul Karim", "01841752600"),
//    Data(5, "Md Rejaul Karim", "01841752600"),
//    Data(6, "Md Rejaul Karim", "01841752600"),
//    Data(7, "Md Rejaul Karim", "01841752600"),
//    Data(8, "Md Rejaul Karim", "01841752600"),
//    Data(9, "Md Rejaul Karim", "01841752600"),
//    Data(10, "Md Rejaul Karim", "01841752600")
//)

@Composable
fun DataView(name: String, phone: String) {
    val context = LocalContext.current

    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(12.dp, 8.dp, 12.dp, 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp, 8.dp, 12.dp, 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pm),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = name,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Cursive,
                    color = colorResource(id = R.color.purple_500),
                    modifier = Modifier.clickable {
                        Toast.makeText(context, "Name", Toast.LENGTH_SHORT).show()
                    }
                )

                Text(
                    text = phone,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Cursive,
                    color = colorResource(id = R.color.purple_500),
                    modifier = Modifier.clickable {
                        Toast.makeText(context, "Phone number", Toast.LENGTH_SHORT).show()
                    }
                )

                Button(onClick = {
                    Toast.makeText(context, "View profile", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "View Profile")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        MainContent()
    }
}