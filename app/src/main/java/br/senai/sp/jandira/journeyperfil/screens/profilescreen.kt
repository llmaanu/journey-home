package br.senai.sp.jandira.journeyperfil.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController



val PrimaryPurple = Color(0xFF1E1C2B)
val PurpleDarker = Color(0xFF341E9B)
val PurpleMedium = Color(0xFF4A3A9D)
val PurpleLighter = Color(0xFF7A68C2)
val White = Color.White

data class UserProfileData(
    val nome: String = "Wilton Pereira Sampaio",
    val email: String = "wilton.sampaio@journey.com",
    val telefone: String = "(11) 94321-2345",
    val bio: String = "Sou desenvolvedor full-stack com experiência em desenvolvimento de sistemas, APIs, IoT, JS, Python e Kotlin. Apaixonado por tecnologia e inovação."
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
    userData: UserProfileData = UserProfileData(),
    onSendPhotoClick: () -> Unit = {},
    onEditInfoClick: () -> Unit = {},
    onEditBioClick: () -> Unit = {},
    isDarkTheme: Boolean
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Meu Perfil",
                        color = White,
                        fontWeight = FontWeight.Bold)},
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home_screen") }) {
                        Icon(Icons.Default.ArrowBack,
                            contentDescription = "Voltar para Home",
                            tint = White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = PurpleDarker, titleContentColor = White)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = PrimaryPurple)
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CardInfoPessoais(
                nome = userData.nome,
                email = userData.email,
                telefone = userData.telefone,
                onEditClick = onEditInfoClick,
                onSendPhotoClick = onSendPhotoClick
            )


            CardBio(
                bio = userData.bio,
                onEditClick = onEditBioClick
            )
        }
    }
}

// ---------------------------------------------------------------------
// COMPONENTES MODULARES
// ---------------------------------------------------------------------

@Composable
fun CardInfoPessoais(
    nome: String,
    email: String,
    telefone: String,
    onEditClick: () -> Unit,
    onSendPhotoClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = PurpleDarker)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ){

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
                , verticalAlignment = Alignment.CenterVertically
            ){
                Text("Informações pessoais",
                    color = White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                Button(onClick = onEditClick,
                    colors = ButtonDefaults.buttonColors(containerColor = PurpleLighter)
                ){
                    Text("Editar",
                        color = Color(0xFF341E9B)
                        , fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                Box(modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(color = PurpleMedium)
                    .border(1.dp,
                        PurpleMedium, CircleShape),
                    contentAlignment = Alignment.Center
                ){
                    Icon(Icons.Default.Person,
                        contentDescription = "Avatar",
                        tint = White,
                        modifier = Modifier
                            .size(40.dp)
                    )
                }

                Button(onClick = onSendPhotoClick,
                    colors = ButtonDefaults.buttonColors(containerColor = PurpleLighter)
                ){
                    Text("Enviar foto",
                        color = Color(0xFF341E9B),
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))


            InfoRow("Nome completo", nome)

            Spacer(modifier = Modifier.height(16.dp))

            InfoRow("Email", email)

            Spacer(modifier = Modifier.height(16.dp))

            InfoRow("Telefone", telefone)
        }
    }
}

@Composable
fun CardBio(bio: String, onEditClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = PurpleDarker),
        border = BorderStroke(1.dp, PurpleMedium)
    ) {
        Column(
            modifier = Modifier
            .padding(16.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically){
                Text("Biografia",
                    color = White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                Button(onClick = onEditClick,
                    colors = ButtonDefaults.buttonColors(containerColor = PurpleLighter)
                ){
                    Text("Editar",
                        color = Color(0xFF341E9B),
                        fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = bio, color = White, fontSize = 14.sp)
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {

    Column(
        modifier = Modifier
            .fillMaxWidth()) {
        Text(text = "$label:",
            color = White,
            fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp,
                    PurpleMedium)
                .padding(8.dp)) {
            Text(
                text = value,
                color = White)
        }
    }
}


