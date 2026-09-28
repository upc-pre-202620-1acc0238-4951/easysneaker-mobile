package pe.edu.upc.easysneaker.features.auth.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import pe.edu.upc.easysneaker.core.designsystem.icon.visibility
import pe.edu.upc.easysneaker.core.designsystem.icon.visibilityOff
import pe.edu.upc.easysneaker.core.designsystem.theme.EasySneakerTheme
import pe.edu.upc.easysneaker.features.auth.presentation.LoginViewModel


@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit
) {

    val state = viewModel.state.collectAsState().value

    LaunchedEffect(state) {
        if (state.isAuthenticated) {
            onLoginSuccess()
        }
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = state.email,
            onValueChange = {
                viewModel.onEmailChanged(it)
            },
            placeholder = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        OutlinedTextField(
            value = state.password,
            onValueChange = {
                viewModel.onPasswordChange(it)
            },
            placeholder = { Text(text = "Password") },
            visualTransformation = if (state.isHidden) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            trailingIcon = {
                IconButton(
                    onClick = viewModel::togglePasswordVisibility
                ) {
                    Icon(
                        imageVector = if (state.isHidden)
                            visibilityOff else
                            visibility, contentDescription = null
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        Button(
            onClick =
                viewModel::signIn, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                "Login"
            )
        }
        OutlinedButton(
            onClick = onRegisterClick, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                "Register"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    EasySneakerTheme {
        LoginScreen(onLoginSuccess = {}) {}
    }
}