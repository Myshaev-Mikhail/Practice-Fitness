package com.example.practice.ui.screens.privacypolicy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.ui.screens.privacypolicy.actions.PrivacyPolicyAction
import com.example.practice.ui.screens.privacypolicy.actions.PrivacyPolicySideEffect
import com.example.practice.ui.uikit.components.BottomNavigation
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons

@Composable
fun PrivacyPolicyScreen(
    navController: NavController
) {
    val viewModel: PrivacyPolicyViewModel = viewModel()
    val state by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    when (sideEffect) {
        is PrivacyPolicySideEffect.NavigateBack -> {
            navController.popBackStack()
            viewModel.clearSideEffect()
        }

        is PrivacyPolicySideEffect.Empty -> {
            // Nothing
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 52.dp, bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(horizontal = 16.dp)
                        .clickable {
                            viewModel.handleUiAction(PrivacyPolicyAction.NavigateBack)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberVectorPainter(Icons.Arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .size(15.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Privacy Policy",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Text(
                    text = "Privacy Policy",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "Your privacy is important to us. This Privacy Policy explains how we collect, use, and protect your personal information when you use our fitness mobile application.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = "1.  Information We Collect",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = """
                        • Email address  
                        • Google account information  
                        • Gender  
                        • Age  
                        • Height  
                        • Weight  
                        • Fitness level  
                        • Personal fitness goals  
                        
                        This information is required to personalize your training experience and provide accurate fitness recommendations.
                        """.trimIndent(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = "2. How We Use Your Information",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = """
                        • Create and manage your account  
                        • Personalize workouts and recommendations  
                        • Track progress and achievements  
                        • Improve app functionality  
                        
                        We do not sell or share your personal data with third parties.
                        """.trimIndent(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = "3. Data Security",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "Your data is stored securely using modern security technologies and protected from unauthorized access.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = "4. Third-Party Services",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "The app may use third-party services such as Google Authentication. These services follow their own privacy policies.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = "5. Your Rights",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "You can access, update, or delete your personal data at any time through the app.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = "6. Data Retention",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "We retain your personal data only for as long as your account is active or as needed to provide our services.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = "7. Changes to This Policy",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "We may update this Privacy Policy from time to time.\n" +
                            "Any changes will be reflected within the app.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = "8. Contact Us",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "If you have any questions about this Privacy Policy or your data, please contact us via the support section in the app.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = "By using this application, you agree to this Privacy Policy.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}