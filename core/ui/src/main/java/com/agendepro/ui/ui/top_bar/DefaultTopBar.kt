package com.agendepro.ui.ui.top_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.agendepro.design_system.ui.AgendeProTheme
import com.agendepro.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    rightIcon: ImageVector? = null,
    onRightIconClick: (() -> Unit)? = null
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = title)
        },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.arrow_left)
                )
            }
        },
        actions = {
            if (rightIcon != null && onRightIconClick != null) {
                IconButton(onClick = onRightIconClick) {
                    Icon(
                        imageVector = rightIcon,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@Composable
@Preview
private fun DefaultTopBarPreview() {
    AgendeProTheme {
        DefaultTopBar(
            title = "Preview",
            onBackClick = {}
        )
    }
}