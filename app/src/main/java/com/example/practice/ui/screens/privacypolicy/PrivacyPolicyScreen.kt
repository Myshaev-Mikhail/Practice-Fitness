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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.R
import com.example.practice.ui.screens.privacypolicy.actions.PrivacyPolicyAction
import com.example.practice.ui.screens.privacypolicy.actions.PrivacyPolicySideEffect
import com.example.practice.ui.uikit.components.BottomNavigation
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.Icons
import org.koin.androidx.compose.koinViewModel

@Composable
fun PrivacyPolicyScreen(
    navController: NavController
) {
    val viewModel: PrivacyPolicyViewModel = koinViewModel()
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
                        text = stringResource(R.string.privacy_policy),
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
                    text = stringResource(R.string.privacy_policy),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = stringResource(R.string.privacy_intro),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = stringResource(R.string.privacy_collect_title),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = stringResource(R.string.privacy_collect_body),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = stringResource(R.string.privacy_use_title),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = stringResource(R.string.privacy_use_body),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = stringResource(R.string.privacy_security_title),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = stringResource(R.string.privacy_security_body),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = stringResource(R.string.privacy_third_party_title),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = stringResource(R.string.privacy_third_party_body),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = stringResource(R.string.privacy_rights_title),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = stringResource(R.string.privacy_rights_body),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = stringResource(R.string.privacy_retention_title),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = stringResource(R.string.privacy_retention_body),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = stringResource(R.string.privacy_changes_title),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = stringResource(R.string.privacy_changes_body),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = stringResource(R.string.privacy_contact_title),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = stringResource(R.string.privacy_contact_body),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = stringResource(R.string.privacy_agreement),
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
