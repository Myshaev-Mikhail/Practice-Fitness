package com.example.practice.ui.screens.editprofile

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.practice.R
import com.example.practice.ui.screens.editprofile.actions.EditProfileAction
import com.example.practice.ui.screens.editprofile.actions.EditProfileSideEffect
import com.example.practice.ui.uikit.components.AppButton
import com.example.practice.ui.uikit.components.AvatarCrop
import com.example.practice.ui.uikit.components.BottomNavigation
import com.example.practice.ui.uikit.components.FormForEfitProfile
import com.example.practice.ui.uikit.theme.LeagueSpartan
import io.github.composegears.valkyrie.Arrow
import io.github.composegears.valkyrie.EditIcon
import io.github.composegears.valkyrie.Icons

@Composable
fun EditProfileScreen(
    navController: NavController,
    viewModel: EditProfileViewModel
) {
    val uiState by viewModel.uiStateEmitter.collectAsState()
    val sideEffect by viewModel.sideEffectEmitter.collectAsState()

    val scrollState = rememberScrollState()
    var isUnsavedChangesDialog by remember { mutableStateOf(false) }

    val launcher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri ->
            uri?.let {
                viewModel.handleUiAction(
                    EditProfileAction.AvatarPicked(it.toString())
                )
            }
        }

    when(sideEffect) {
        is EditProfileSideEffect.ShowNavigateBack -> {
            navController.popBackStack()
            viewModel.clearSideEffect()
        }

        is EditProfileSideEffect.ShowUnsavedChangesDialog -> {
            isUnsavedChangesDialog = true
            viewModel.clearSideEffect()
        }

        is EditProfileSideEffect.Empty -> {
            // Nothing
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(bottom = 48.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.tertiary)
                    .padding(top = 44.dp, bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(horizontal = 16.dp)
                        .clickable {
                            viewModel.handleUiAction(EditProfileAction.NavigateBack)
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
                        text = "My Profile",
                        color = MaterialTheme.colorScheme.outline,
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                Box(
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        launcher.launch("image/*")
                    }
                ) {
                    AsyncImage(
                        model = uiState.tempAvatarUri
                            ?: uiState.avatarUri
                            ?: R.mipmap.ic_group1,
                        contentDescription = "Avatar",
                        modifier = Modifier
                            .size(125.dp)
                            .align(Alignment.Center)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                        error = painterResource(id = R.mipmap.ic_group1)
                    )

                    Image(
                        painter = rememberVectorPainter(Icons.EditIcon),
                        contentDescription = "edit",
                        modifier = Modifier.align(Alignment.BottomEnd)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "${uiState.fullName}",
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "${uiState.email}",
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "Birthday: April 1st",
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(20.dp))
            }

            Row(
                modifier = Modifier
                    .offset(y = -(32.dp))
                    .padding(start = 32.dp, end = 32.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text ="${uiState.weight} Kg",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Weight",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .width(1.dp)
                        .height(42.dp)
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${uiState.date}",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Years Old",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .width(1.dp)
                        .height(42.dp)
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${uiState.height} CM",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Height",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                FormForEfitProfile(
                    fullName = uiState.fullName.orEmpty(),
                    email = uiState.email.orEmpty(),
                    mobileNumber = uiState.mobileNumber.orEmpty(),
                    date = uiState.date?.toString().orEmpty(),
                    weight = uiState.weight?.toString().orEmpty(),
                    height = uiState.height?.toString().orEmpty(),

                    onFullNameChange = {
                        viewModel.handleUiAction(EditProfileAction.FullNameChanged(it))
                    },
                    onEmailChange = {
                        viewModel.handleUiAction(EditProfileAction.EmailChanged(it))
                    },
                    onMobileNumberChange = {
                        viewModel.handleUiAction(EditProfileAction.MobileChanged(it))
                    },
                    onDateChange = {
                        viewModel.handleUiAction(EditProfileAction.AgeChanged(it))
                    },
                    onWeightChange = {
                        viewModel.handleUiAction(EditProfileAction.WeightChanged(it))
                    },
                    onHeightChange = {
                        viewModel.handleUiAction(EditProfileAction.HeightChanged(it))
                    }
                )
                AppButton(
                    modifier = Modifier
                        .width(180.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 24.dp),
                    text = "Update Profile",
                    textColor = MaterialTheme.colorScheme.onSecondary,
                    textStyle = TextStyle(
                        fontFamily = LeagueSpartan,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 17.sp
                    ),
                    buttonColor = MaterialTheme.colorScheme.secondary,
                ) {
                    viewModel.handleUiAction(EditProfileAction.SaveProfile)
                }
            }
        }
        BottomNavigation(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )

        if (isUnsavedChangesDialog) {
            Dialog(
                onDismissRequest = {
                    isUnsavedChangesDialog = false
                    viewModel.clearSideEffect()
                },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colorScheme.tertiary,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "You have unsaved changes!",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Spacer(Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            AppButton(
                                modifier = Modifier.width(120.dp),
                                text = "Cancel",
                                textStyle = MaterialTheme.typography.headlineSmall,
                                buttonColor = MaterialTheme.colorScheme.secondary,
                                textColor = MaterialTheme.colorScheme.onSecondary
                            ) {
                                isUnsavedChangesDialog = false
                                viewModel.clearSideEffect()
                            }

                            Spacer(Modifier.width(16.dp))

                            AppButton(
                                modifier = Modifier.width(120.dp),
                                text = "Exit",
                                textStyle = MaterialTheme.typography.headlineSmall,
                                buttonColor = MaterialTheme.colorScheme.onPrimary,
                                textColor = MaterialTheme.colorScheme.onSecondary
                            ) {
                                isUnsavedChangesDialog = false
                                viewModel.clearSideEffect()
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
    if (uiState.tempAvatarUri != null) {
        Dialog(
            onDismissRequest = {
                viewModel.handleUiAction(EditProfileAction.ClearTempAvatar)
            },
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ) {
            AvatarCrop(
                imageUri = uiState.tempAvatarUri!!,
                onConfirm = { finalUri ->
                    viewModel.handleUiAction(
                        EditProfileAction.AvatarConfirmed(finalUri)
                    )
                },
                onCancel = {
                    viewModel.handleUiAction(EditProfileAction.ClearTempAvatar)
                }
            )
        }
    }
}