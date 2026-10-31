package com.example.myapplication

import android.R.attr.text
import androidx.compose.ui.text.font.FontStyle
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Task7(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

//1
@Composable
fun Hello(
    name: String?,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = name ?: "Имя не задано",
            textAlign = TextAlign.Center
        )
    }
}

//2
@Preview(
    device = Devices.PHONE,
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HelloPreviewPortrait() {
    Hello("Kirill Dudkin")
}


@Preview(
    device = Devices.TABLET,
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HelloPreviewLandscape() {
    Hello(name = "Kirill Dudkin")
}


@Preview(
    device = "id:wearos_small_round",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HelloPreviewRound() {
    Surface(color = Color.Yellow) {
        Hello(name = "Dudkin Kirill")
    }
}


//3
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun TextPreview(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(8.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = stringResource(R.string.task_3_text),
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(R.string.task_3_text),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = stringResource(R.string.task_3_text),
            modifier = Modifier.background(color = Color.Green),
            color = Color.Black,
            fontSize = 24.sp,
            textDecoration = TextDecoration.Underline,
            style = TextStyle(
                textIndent = TextIndent(
                    firstLine = 48.sp
                )
            )
        )
    }
}


//4
@Preview(
    showBackground = true,
)
@Composable
fun Task4ButtonScreen(
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black,
        ),
        onClick = {},
    ) {
        Text(
            text = "Нажми на меня"
        )

    }
}


//5
@Preview(showBackground = true)
@Composable
fun Task5(modifier: Modifier = Modifier) {
    // Внешний серый контейнер
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(Color(0xFFFF9800)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "DK"
            )
        }
    }
}


//6
@Preview(showBackground = true)
@Composable
fun Task6First(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Orange circle"
        )
    }
}
@Preview(showBackground = true)
@Composable
fun Task6Second(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Purple oval",
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(Color(0xFF8B00FF)),
            contentScale = ContentScale.FillBounds
        )
    }
}



//7
data class User(
    val name: String,
    val lastname: String,
    val patronymic: String,
    val phoneNumber: String,
    val address: String,
)

private val USERS_DATA = listOf(
    User("Дудкин", "Кирилл", "Романович", "+7 777 777 77 77", "г. Москва, Саларьевская 14 к2,  кв. 631"),
    User("Гладышев", "Петр", "Анатольевич", "-", "Ивановская область, дер. Крутово, д.4"),
    User("Белова", "Инна", "Вячеславовна", "+7 666 666 66 66", "г. Москва, улица Большая Никитская, д. 43, кв. 290")
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Task7(modifier: Modifier = Modifier) {
    val permanentUser = USERS_DATA[0] // Возьмем первого пользователя для одиночных карточек

    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Имя: ${permanentUser.name}")
                Text(text = "Отчество: ${permanentUser.patronymic}")
                Text(text = "Фамилия: ${permanentUser.lastname}")
                Text(text = "Мобильный телефон: ${permanentUser.phoneNumber}")
                Text(text = "Адрес: ${permanentUser.address}")
            }
        }
        for (user in USERS_DATA) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp) // Внешний отступ от других карточек
                        .background(Color.LightGray)
                        .padding(8.dp), // Внутренний отступ текста от краев карточки
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally // Текст по центру карточки
                ) {
                    Text(text = "Имя: ${user.name}", textAlign = TextAlign.Center)
                    Text(text = "Отчество: ${user.patronymic}", textAlign = TextAlign.Center)
                    Text(text = "Фамилия: ${user.lastname}", textAlign = TextAlign.Center)
                    Text(text = "Мобильный телефон: ${user.phoneNumber}", textAlign = TextAlign.Center)
                    Text(text = "Адрес: ${user.address}", textAlign = TextAlign.Center)
                }
            }
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.LightGray),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Левая часть (Текст), заберет 5 частей ширины
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Имя: ${permanentUser.name}", textAlign = TextAlign.Center)
                    Text(text = "Отчество: ${permanentUser.patronymic}", textAlign = TextAlign.Center)
                    Text(text = "Фамилия: ${permanentUser.lastname}", textAlign = TextAlign.Center)
                    Text(text = "Мобильный телефон: ${permanentUser.phoneNumber}", textAlign = TextAlign.Center)
                    Text(text = "Адрес: ${permanentUser.address}", textAlign = TextAlign.Center)
                }

                // Правая часть (Картинка), заберет 1 часть ширины
                Image(
                    painter = painterResource(R.drawable.circle), // Используем картинку круга
                    contentDescription = "Circle",
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}


//8
private const val WATER_PER_CUP = 250
private const val DAILY_WATER_MINIMUM = 1500
@Preview(showBackground = true)
@Composable
fun WaterTracker() {
    var waterCount by remember { mutableIntStateOf(0) }
    var streakDays by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val primaryColor = MaterialTheme.colorScheme.primary
        val secondaryColor = MaterialTheme.colorScheme.secondary

        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Текущая серия: $streakDays дней",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            onClick = { waterCount += WATER_PER_CUP }
        ) {
            Text(
                text = "+$WATER_PER_CUP мл",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = secondaryColor),
            onClick = {
                streakDays = if (waterCount >= DAILY_WATER_MINIMUM) {
                    streakDays + 1
                } else {
                    0
                }
                waterCount = 0
            }
        ) {
            Text(
                text = "Завершить день",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}