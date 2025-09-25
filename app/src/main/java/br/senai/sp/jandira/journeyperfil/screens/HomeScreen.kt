package br.senai.sp.jandira.journeyperfil.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.jouneyperfil.ui.theme.JouneyperfilTheme
import br.senai.sp.jandira.journeyperfil.R

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


object AppThemeColors {
    val LightPrimary = Color(0xFF341E9B)
    val LightSecondary = Color(0xFF7A68C2)
    val LightBackground = Color(0xFFF0E5FF)
    val LightText = Color.Black
    val LightTextOnPrimary = Color.White


    val DarkPrimary = Color(0xFF1F1B38)
    val DarkSecondary = Color(0xFF3C3456)
    val DarkBackground = Color(0xFF121212)
    val DarkText = Color.White
    val DarkTextOnPrimary = Color.White

data class Group(
    val id: Int,
    val icon: ImageVector,
    val title: String,
    val members: String
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    drawerState: DrawerState,
    scope: CoroutineScope,
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit
) {

    val themeIcon = if (isDarkTheme) {
        painterResource(id = br.senai.sp.jandira.journeyperfil.R.drawable.claro)
    } else {
        painterResource(id = br.senai.sp.jandira.journeyperfil.R.drawable.escuro)
    }

    val currentColors = if (isDarkTheme) AppThemeColors.DarkBackground else AppThemeColors.LightBackground
    val primaryColor = if (isDarkTheme) AppThemeColors.DarkPrimary else AppThemeColors.LightPrimary
    val secondaryColor = if (isDarkTheme) AppThemeColors.DarkSecondary else AppThemeColors.LightSecondary
    val textColor = if (isDarkTheme) AppThemeColors.DarkText else AppThemeColors.LightText
    val textColorOnPrimary = AppThemeColors.LightTextOnPrimary
    // -----------------------------------------------------------------------------------


    var groups by remember {
        mutableStateOf(listOf<Group>(
            Group(1, Icons.Default.Person, "Direito", "8 membros"),
            Group(2, Icons.Default.Add, "Desenvolvimento\nde sistemas", "12 membros"),
            Group(3, Icons.Default.Person, "Contabilidade", "26 membros")
        ))
    }

    var showCategoryDropdown by remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Journey",
                            color = textColorOnPrimary,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 2.sp,
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentWidth(Alignment.CenterHorizontally)
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.padding(end = 16.dp)
                        ) {

                            IconButton(onClick = onThemeToggle) {
                                Image(
                                    painter = themeIcon,
                                    contentDescription = "Alternar Tema",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                            IconButton(onClick = { navController.navigate("profile_screen") }) {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Perfil",
                                    tint = textColorOnPrimary
                                )
                            }
                        }
                    }
                },
                navigationIcon = {
                    Row(
                        modifier = Modifier.padding(start = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu", tint = textColorOnPrimary)
                        }
                        Image(
                            painter = painterResource(id = R.drawable.logoclaro),
                            contentDescription = "Avatar",
                            modifier = Modifier.size(40.dp).clip(CircleShape)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = primaryColor)
            )
        },
        containerColor = currentColors
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "Bem-vindo ao\nJourney!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                color = textColor,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Uma plataforma para mentoria e aprendizado colaborativo",
                fontSize = 16.sp,
                textAlign = TextAlign.Left,
                color = textColor,
                modifier = Modifier.fillMaxWidth()
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = primaryColor),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(text = "Grupos", color = textColorOnPrimary, fontSize = 24.sp, fontWeight = FontWeight.Bold)


                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {

                        Button(
                            onClick = { navController.navigate("create_group_screen") },
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Criar", tint = primaryColor)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Criar Grupo", color = primaryColor, fontWeight = FontWeight.SemiBold)
                        }


                        Box(modifier = Modifier.weight(1f)) {
                            Button(
                                onClick = { showCategoryDropdown = true },
                                shape = RoundedCornerShape(50),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Icon(Icons.Outlined.KeyboardArrowDown, contentDescription = "Categoria", tint = primaryColor)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Categoria", color = primaryColor, fontWeight = FontWeight.SemiBold)
                            }


                            DropdownMenu(
                                expanded = showCategoryDropdown,
                                onDismissRequest = { showCategoryDropdown = false }
                            ) {
                                DropdownMenuItem(text = { Text("Todas") }, onClick = { showCategoryDropdown = false /* Lógica de Filtro */ })
                                DropdownMenuItem(text = { Text("Tecnologia") }, onClick = { showCategoryDropdown = false /* Lógica de Filtro */ })
                                DropdownMenuItem(text = { Text("Humanas") }, onClick = { showCategoryDropdown = false /* Lógica de Filtro */ })
                            }
                        }
                    }

                    groups.forEach { group ->
                        GroupItem(
                            group = group,
                            secondaryColor = secondaryColor,
                            primaryColor = primaryColor
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GroupItem(group: Group, secondaryColor: Color, primaryColor: Color) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable {  },
        colors = CardDefaults.cardColors(containerColor = secondaryColor),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(1.dp, primaryColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = group.icon,
                    contentDescription = null,
                    tint = primaryColor,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = group.title,
                    color = primaryColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 18.sp
                )
                Text(
                    text = group.members,
                    color = primaryColor,
                    fontSize = 12.sp
                )
            }
        }
    }
}


@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    var isDarkTheme by remember { mutableStateOf(false) }

    JouneyperfilTheme {
        HomeScreen(
            navController = navController,
            drawerState = drawerState,
            scope = scope,
            isDarkTheme = isDarkTheme,
            onThemeToggle = { isDarkTheme = !isDarkTheme }
        )
    }
}}