package tadepalli.userinputvalidation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LandingScreen(
    modifier: Modifier = Modifier,
    landingScreenViewModel: LandingScreenViewModel
) {
    LandingScreenContent(
        modifier = modifier,
    )
}

@Composable
fun LandingScreenContent(
    modifier: Modifier = Modifier,
    userName: String = "",
    enableSubmitButton: Boolean = false,
    enableResetButton: Boolean = false,
    onValueChange: (String) -> Unit = {},
    onSubmitClicked: () -> Unit = {},
    onResetClicked: () -> Unit = {},
) {
    Column(
        modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        UserNameRulesDisplay(
            modifier = Modifier.padding(all = 8.dp)
        )
        UserNameTextField(
            userName = userName,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { userName ->
                onValueChange(userName)
            }
        )
        SubmitResetActions(
            modifier = Modifier.fillMaxWidth(),
            enableSubmitButton = enableSubmitButton,
            enableResetButton = enableResetButton,
            onSubmitClicked = {
                onSubmitClicked()
            },
            onResetClicked = {
                onResetClicked()
            }
        )
    }
}


@Composable
fun UserNameRulesDisplay(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "Rules \n1. Atleast one uppercase letter\n" +
                "2. Atleast one numeric character\n" +
                "3. Minimum 8 characters long\n" +
                "4. Maximum 12 characters only",
    )
}


@Composable
fun UserNameTextField(
    modifier: Modifier = Modifier,
    userName: String = "",
    onValueChange: (String) -> Unit = {},
) {
    var textInput by remember { mutableStateOf(userName) }
    TextField(
        value = textInput,
        onValueChange = {
            textInput = it
            onValueChange(it)
        },
        singleLine = true,
        modifier = modifier.padding(top = 16.dp, end = 16.dp),
    )
}

@Composable
fun SubmitResetActions(
    modifier: Modifier = Modifier,
    enableSubmitButton: Boolean = false,
    enableResetButton: Boolean = false,
    onSubmitClicked: () -> Unit = {},
    onResetClicked: () -> Unit = {},
) {
    Row(
        modifier = modifier,
    ) {
        Button(
            modifier = Modifier.weight(1f).padding(all = 8.dp),
            enabled = enableSubmitButton,
            onClick = {
                onSubmitClicked()
            },
        ) {
            Text(text = "Submit")
        }
        Button(
            modifier = Modifier.weight(1f).padding(all = 8.dp),
            enabled = enableResetButton,
            onClick = {
                onResetClicked()
            },
        ) {
            Text(text = "Reset")
        }
    }
}