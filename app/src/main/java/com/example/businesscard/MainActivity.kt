package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(
    modifier: Modifier = Modifier
){
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color(0xFF0C4160)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom) {


            HeaderInfoParticulars(
                painterImage = painterResource(id = R.drawable.android_logo),
                name = stringResource(R.string.card_name),
                title = stringResource(R.string.card_title), modifier.padding(bottom = 150.dp)
            )


        Column() {
            Divider(color = Color.White,)
            ContactDetails(icon = painterResource(id = R.drawable.baseline_settings_phone_black_24dp),
                contactDetail = stringResource(R.string.contact_details), modifier.padding(bottom = 4.dp, start = 20.dp))
            Divider(color = Color.White,)
            ContactDetails(icon = painterResource(id = R.drawable.baseline_share_black_24dp),
                contactDetail = stringResource(R.string.social_media), modifier.padding(bottom = 4.dp, start = 20.dp))
            Divider(color = Color.White,)
            ContactDetails(icon = painterResource(id = R.drawable.baseline_mail_black_24dp),
                contactDetail = stringResource(R.string.email_contact), modifier.padding(bottom = 20.dp, start = 20.dp))
        }
    }
   }





@Composable
private fun HeaderInfoParticulars(
    painterImage: Painter,
    name: String,
    title: String,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Image(painter = painterImage, contentDescription = null, Modifier.size(105.dp))

        Text(text = name, fontSize = 56.sp,color = Color.White,)

        Text(text = title, fontWeight = FontWeight.Bold, color = Color.Green)
    }

}


@Composable
private fun ContactDetails(
    icon: Painter,
    contactDetail: String,
    modifier: Modifier = Modifier
){
        Row(modifier = modifier.padding(top = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {

            Image(painter = icon, contentDescription = null,
                modifier = modifier.size(20.dp))

            Text(text = contactDetail, modifier = modifier.padding())
        }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Surface {
            BusinessCardApp()
        }
    }
}