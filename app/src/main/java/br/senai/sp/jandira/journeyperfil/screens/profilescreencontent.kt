import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.jouneyperfil.ui.theme.JouneyperfilTheme
import br.senai.sp.jandira.journeyperfil.ui.theme.PurpleDarker
import br.senai.sp.jandira.journeyperfil.ui.theme.PurpleLighter
import br.senai.sp.jandira.journeyperfil.ui.theme.PurpleMedium
import br.senai.sp.jandira.journeyperfil.ui.theme.White

@Composable
fun ProfileScreenContent() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = PurpleMedium)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(color = PurpleDarker)
                    .border(1.dp, PurpleMedium, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Avatar",
                    tint = White,
                    modifier = Modifier.size(40.dp)
                )
            }
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = PurpleLighter)
            ) {
                Text("Enviar foto", color = PurpleDarker, fontWeight = FontWeight.Bold)
            }
        }
        CardInfoPessoais()
        CardBio()
    }
}
@Composable
fun CardInfoPessoais() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = PurpleDarker),
        border = BorderStroke(1.dp, PurpleMedium)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Informações pessoais",
                    color = White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = PurpleLighter)
                ) {
                    Text("Editar", color = PurpleDarker, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            InfoRow("Nome completo", "Wilton Pereira Sampaio")
            Spacer(modifier = Modifier.height(16.dp))
            InfoRow("Email", "xxxxxxxxxx@gmail.com")
            Spacer(modifier = Modifier.height(16.dp))
            InfoRow("Telefone", "(11) 94321-2345")
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CardBio() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = PurpleDarker),
        border = BorderStroke(1.dp, PurpleMedium)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Biografia", color = White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = PurpleLighter)
                ) {
                    Text("Editar", color = PurpleDarker, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Sou desenvolvedor full-stack com experiência em desenvolvimento de sistemas, APIs, IoT, JS, Python e Kotlin. Apaixonado por tecnologia e inovação.",
                color = White,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "$label:", color = White, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, PurpleMedium)
                .padding(8.dp)
        ) {
            Text(
                text = value,
                color = White
            )
        }
    }
}

// Preview should now show the content only
@Preview(showBackground = true)
@Composable
fun ProfileScreenContentPreview() {
    JouneyperfilTheme {
        ProfileScreenContent()
    }
}