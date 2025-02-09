package tadepalli.userinputvalidation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.ui.Modifier
import tadepalli.userinputvalidation.ui.screens.LandingScreen
import tadepalli.userinputvalidation.ui.screens.LandingScreenViewModel
import tadepalli.userinputvalidation.ui.screens.LandingScreenViewModelFactory
import tadepalli.userinputvalidation.ui.theme.UserInputValidationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val landingScreenViewModel: LandingScreenViewModel by viewModels {
            LandingScreenViewModelFactory()
        }

        setContent {
            UserInputValidationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                colors = topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    titleContentColor = MaterialTheme.colorScheme.primary,
                                ),
                                title = {
                                    Text("UserName entry")
                                }
                            )
                        },
                    ) { innerPadding ->
                        LandingScreen(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize(),
                            landingScreenViewModel = landingScreenViewModel
                        )
                    }
                }
            }
        }
    }
}
