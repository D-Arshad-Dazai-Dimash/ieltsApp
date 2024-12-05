package com.example.ielts_application_pm.ui.screens.games.listening

//@Composable
//fun VideoPlayer(uri: String, onVideoEnd: () -> Unit) {
//    val context = LocalContext.current
//    var exoPlayer by remember { mutableStateOf<ExoPlayer?>(null) }
//
//    DisposableEffect(uri) {
//        exoPlayer?.release()
//
//        exoPlayer = ExoPlayer.Builder(context).build().apply {
//            setMediaItem(MediaItem.fromUri(uri))
//            prepare()
//            playWhenReady = true
//        }
//
//        val listener = object : Player.Listener {
//            override fun onPlaybackStateChanged(state: Int) {
//                if (state == Player.STATE_ENDED) {
//                    onVideoEnd()
//                }
//            }
//        }
//        exoPlayer?.addListener(listener)
//
//        onDispose {
//            exoPlayer?.removeListener(listener)
//            exoPlayer?.release()
//        }
//    }
//
//    AndroidView(
//        factory = {
//            PlayerView(context).apply {
//                player = exoPlayer
//                useController = true
//                layoutParams = android.view.ViewGroup.LayoutParams(
//                    android.view.ViewGroup.LayoutParams.MATCH_PARENT,
//                    android.view.ViewGroup.LayoutParams.MATCH_PARENT
//                )
//            }
//        },
//        modifier = Modifier.fillMaxSize()
//    )
//}


import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun VideoPlayer(uri: String, onVideoEnd: () -> Unit) {
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(uri))
            prepare ()
            playWhenReady = true
        }
    }
    DisposableEffect(exoPlayer) {
        val listener = object : Player.Listener {
            override fun onPlaybackStateChanged(state: Int) {
                if (state == Player.STATE_ENDED) {
                    onVideoEnd()
                }
            }
        }
        exoPlayer.addListener (listener)
        onDispose {
            exoPlayer.removeListener(listener)
            exoPlayer.release()
        }
    }
    AndroidView(factory = { PlayerView(context).apply { player = exoPlayer } })
}
