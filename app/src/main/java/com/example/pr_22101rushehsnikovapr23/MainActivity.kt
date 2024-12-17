package com.example.pr_22101rushehsnikovapr23

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    var currentScreen by remember { mutableStateOf(Screen.SplashScreen) }

    when (currentScreen) {
        Screen.SplashScreen -> SplashScreen { currentScreen = Screen.AnalysisScreen }
        Screen.AnalysisScreen -> AnalysisScreen { currentScreen = Screen.NotificationsScreen }
        Screen.NotificationsScreen -> NotificationsScreen { currentScreen = Screen.MonitoringScreen }
        Screen.MonitoringScreen -> MonitoringScreen()
    }

}

enum class Screen {
    SplashScreen, AnalysisScreen, NotificationsScreen, MonitoringScreen
}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    val image: Painter = painterResource(id = R.drawable.logo)
    val text = "Смартлаб"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF42A5F5)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 10.dp) // Отступ от изображения
            )
            Image(
                painter = image,
                contentDescription = "Splash Screen",
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
        }
        LaunchedEffect(key1 = true) {
            delay(3000)
            onTimeout()
        }
    }
}
@Composable
fun AnalysisScreen(onNext: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Анализы",
                color = Color(0xFF4CAF50),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Экспресс сбор и получение проб",
                color = Color.Gray,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
        Button(
            onClick = onNext,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.End), // Выравнивание по правому краю
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        ) {
            Text(
                text = "Пропустить",
                color = Color(0xFF42A5F5)
            )
        }
    }
}


@Composable
fun NotificationsScreen(onNext: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Уведомления",
            color = Color(0xFF4CAF50),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Вы быстро узнаете о результатах",
            color = Color.Gray,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onNext,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.End),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        ) {
            Text(
                text = "Пропустить",
                color = Color(0xFF42A5F5)
            )
        }
    }
}

@Composable
fun MonitoringScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Мониторинг",
            color = Color(0xFF4CAF50),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Наши врачи всегда наблюдают за вашими показателями здоровья.",
            color = Color.Gray,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.End),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        ) {
            Text(
                text = "Завершить",
                color = Color(0xFF42A5F5)
            )
        }
    }
}


fun delay(millis: Long) = Handler(Looper.getMainLooper()).postDelayed({ }, millis)