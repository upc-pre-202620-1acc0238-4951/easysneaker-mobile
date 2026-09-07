package pe.edu.upc.easysneaker.features.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.easysneaker.R
import pe.edu.upc.easysneaker.core.arrowForward
import pe.edu.upc.easysneaker.core.theme.EasySneakerTheme


@Composable
fun OnBoardingScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = "On Boarding Background"
        )
        Spacer(modifier = Modifier.weight(2f))
        Text(
            "Boost Your Style Sense",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Discover, shop, and unlock exciting sneakers tailored just for you",
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = { },
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Icon(
                imageVector = arrowForward,
                contentDescription = "Next",
                modifier = Modifier
                    .clip(
                        CircleShape
                    )


            )

        }



        Spacer(modifier = Modifier.weight(1f))


    }

}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    EasySneakerTheme {
        OnBoardingScreen()

    }
}