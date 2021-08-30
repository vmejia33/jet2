/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetnews.ui.article

import android.content.Context
import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUpOffAlt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnews.R
import com.example.jetnews.data.Result
import com.example.jetnews.data.posts.impl.BlockingFakePostsRepository
import com.example.jetnews.data.posts.impl.post3
import com.example.jetnews.model.Post
import com.example.jetnews.ui.components.InsetAwareTopAppBar
import com.example.jetnews.ui.components.JetnewsNavRail
import com.example.jetnews.ui.home.BookmarkButton
import com.example.jetnews.ui.theme.JetnewsTheme
import com.example.jetnews.utils.isScrolled
import com.google.accompanist.insets.navigationBarsPadding
import kotlinx.coroutines.runBlocking

/**
 * Displays the Article screen.
 *
 * @param articleViewModel ViewModel that handles the business logic of this screen
 * @param showNavRail (state) whether the Drawer or NavigationRail needs to be shown
 * @param onBack (event) request back navigation
 */
@Composable
fun ArticleScreen(
    articleViewModel: ArticleViewModel,
    showNavRail: Boolean,
    onBack: () -> Unit
) {
    // UiState of the ArticleScreen
    val uiState by articleViewModel.uiState.collectAsState()

    if (uiState.post != null) {
        ArticleAdaptiveScreen(
            post = uiState.post!!,
            showNavRail = showNavRail,
            onBack = onBack,
            isFavorite = uiState.isFavorite,
            onToggleFavorite = { articleViewModel.toggleFavorite() }
        )
    }

    // Check for failures while loading the state
    // TODO: Improve UX
    LaunchedEffect(uiState) {
        if (uiState.failedLoading) {
            onBack()
        }
    }
}

/**
 * Stateless Article Screen that displays a single post adapting the UI to different screen sizes.
 *
 * @param post (state) item to display
 * @param showNavRail (state) whether the Drawer or NavigationRail needs to be shown
 * @param onBack (event) request navigate back
 * @param isFavorite (state) is this item currently a favorite
 * @param onToggleFavorite (event) request that this post toggle it's favorite state
 */
@Composable
private fun ArticleAdaptiveScreen(
    post: Post,
    showNavRail: Boolean,
    onBack: () -> Unit,
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit
) {
    var showUnimplementedActionDialog by rememberSaveable { mutableStateOf(false) }
    if (showUnimplementedActionDialog) {
        FunctionalityNotAvailablePopup { showUnimplementedActionDialog = false }
    }

    val context = LocalContext.current
    if (showNavRail) {
        Row(Modifier.fillMaxSize()) {
            InterestsNavRail(
                onBack = onBack,
                onUnimplementedAction = { showUnimplementedActionDialog = true },
                isFavorite = isFavorite,
                onToggleFavorite = onToggleFavorite,
                onSharePost = { sharePost(post, context) }
            )
            ArticleScreenContent(post = post)
        }
    } else {
        ArticleScreenContent(
            post = post,
            navigationIconContent = {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.cd_navigate_up),
                        tint = MaterialTheme.colors.primary
                    )
                }
            },
            bottomBarContent = {
                BottomBar(
                    onUnimplementedAction = { showUnimplementedActionDialog = true },
                    isFavorite = isFavorite,
                    onToggleFavorite = onToggleFavorite,
                    onSharePost = { sharePost(post, context) }
                )
            }
        )
    }
}

/**
 * Stateless Article Screen that displays a single post.
 *
 * @param post (state) item to display
 * @param navigationIconContent (UI) content to show for the navigation icon
 * @param bottomBarContent (UI) content to show for the bottom bar
 */
@Composable
private fun ArticleScreenContent(
    post: Post,
    navigationIconContent: @Composable (() -> Unit)? = null,
    bottomBarContent: @Composable () -> Unit = { }
) {
    val scrollState = rememberLazyListState()
    Scaffold(
        topBar = {
            InsetAwareTopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_article_background),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(36.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.published_in, post.publication?.name ?: ""),
                            style = MaterialTheme.typography.subtitle2,
                            color = LocalContentColor.current,
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .weight(1.5f)
                        )
                    }
                },
                navigationIcon = navigationIconContent,
                elevation = if (!scrollState.isScrolled) 0.dp else 4.dp,
                backgroundColor = MaterialTheme.colors.surface
            )
        },
        bottomBar = bottomBarContent
    ) { innerPadding ->
        PostContent(
            post = post,
            state = scrollState,
            modifier = Modifier
                // innerPadding takes into account the top and bottom bar
                .padding(innerPadding)
                // offset content in landscape mode to account for the navigation bar
                .navigationBarsPadding(bottom = false)
        )
    }
}

/**
 * Bottom bar for Article screen
 *
 * @param onUnimplementedAction (event) called when the user performs an unimplemented action
 * @param isFavorite (state) if this post is currently a favorite
 * @param onToggleFavorite (event) request this post toggle it's favorite status
 * @param onSharePost (event) request this post to be shared
 */
@Composable
private fun InterestsNavRail(
    onBack: () -> Unit,
    onUnimplementedAction: () -> Unit,
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    onSharePost: () -> Unit
) {
    JetnewsNavRail(
        topIcon = { modifier ->
            IconButton(onClick = onBack, modifier = modifier) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.cd_navigate_up),
                    tint = MaterialTheme.colors.primary
                )
            }
        }
    ) {
        IconButton(onClick = onUnimplementedAction) {
            Icon(
                imageVector = Icons.Filled.ThumbUpOffAlt,
                contentDescription = stringResource(R.string.cd_add_to_favorites)
            )
        }
        BookmarkButton(
            isBookmarked = isFavorite,
            onClick = onToggleFavorite
        )
        IconButton(onClick = onSharePost) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = stringResource(R.string.cd_share)
            )
        }
        IconButton(onClick = onUnimplementedAction) {
            Icon(
                painter = painterResource(R.drawable.ic_text_settings),
                contentDescription = stringResource(R.string.cd_text_settings)
            )
        }
    }
}

/**
 * Bottom bar for Article screen
 *
 * @param onUnimplementedAction (event) called when the user performs an unimplemented action
 * @param isFavorite (state) if this post is currently a favorite
 * @param onToggleFavorite (event) request this post toggle it's favorite status
 * @param onSharePost (event) request this post to be shared
 */
@Composable
private fun BottomBar(
    onUnimplementedAction: () -> Unit,
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    onSharePost: () -> Unit
) {
    Surface(elevation = 8.dp) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .navigationBarsPadding()
                .height(56.dp)
                .fillMaxWidth()
        ) {
            IconButton(onClick = onUnimplementedAction) {
                Icon(
                    imageVector = Icons.Filled.ThumbUpOffAlt,
                    contentDescription = stringResource(R.string.cd_add_to_favorites)
                )
            }
            BookmarkButton(
                isBookmarked = isFavorite,
                onClick = onToggleFavorite
            )
            IconButton(onClick = onSharePost) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = stringResource(R.string.cd_share)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = onUnimplementedAction) {
                Icon(
                    painter = painterResource(R.drawable.ic_text_settings),
                    contentDescription = stringResource(R.string.cd_text_settings)
                )
            }
        }
    }
}

/**
 * Display a popup explaining functionality not available.
 *
 * @param onDismiss (event) request the popup be dismissed
 */
@Composable
private fun FunctionalityNotAvailablePopup(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        text = {
            Text(
                text = stringResource(id = R.string.article_functionality_not_available),
                style = MaterialTheme.typography.body2
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = stringResource(id = R.string.close))
            }
        }
    )
}

/**
 * Show a share sheet for a post
 *
 * @param post to share
 * @param context Android context to show the share sheet in
 */
private fun sharePost(post: Post, context: Context) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TITLE, post.title)
        putExtra(Intent.EXTRA_TEXT, post.url)
    }
    context.startActivity(Intent.createChooser(intent, context.getString(R.string.article_share_post)))
}

@Preview("Article screen")
@Preview("Article screen (dark)", uiMode = UI_MODE_NIGHT_YES)
@Preview("Article screen (big font)", fontScale = 1.5f)
@Composable
fun PreviewArticleDrawer() {
    JetnewsTheme {
        val post = runBlocking {
            (BlockingFakePostsRepository().getPost(post3.id) as Result.Success).data
        }
        ArticleAdaptiveScreen(post, false, {}, false, {})
    }
}

@Preview("Article screen navrail", device = Devices.PIXEL_C)
@Preview(
    "Article screen navrail (dark)",
    uiMode = UI_MODE_NIGHT_YES,
    device = Devices.PIXEL_C
)
@Preview("Article screen navrail (big font)", fontScale = 1.5f, device = Devices.PIXEL_C)
@Composable
fun PreviewArticleNavRail() {
    JetnewsTheme {
        val post = runBlocking {
            (BlockingFakePostsRepository().getPost(post3.id) as Result.Success).data
        }
        Surface {
            ArticleAdaptiveScreen(post, true, {}, false, {})
        }
    }
}
