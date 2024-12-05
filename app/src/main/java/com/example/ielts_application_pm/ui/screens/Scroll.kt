//package com.example.ielts_application_pm.ui.screens
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
//import androidx.compose.ui.input.nestedscroll.nestedScroll
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.zIndex
//import androidx.compose.ui.unit.IntOffset
//
//
//@Composable
//fun ScrollEffectScreen() {
////    // Track the offset of the header
////    var headerOffset by remember { mutableStateOf(0f) }
////    val maxHeaderHeight = 500.dp
////    val minHeaderHeight = 56.dp
////    val maxOffsetPx = with(LocalDensity.current) { maxHeaderHeight.toPx() - minHeaderHeight.toPx() }
////
////    val nestedScrollConnection = remember {
////        object : NestedScrollConnection {
////            override fun onPreScroll(
////                available: Offset,
////                source: androidx.compose.ui.input.nestedscroll.NestedScrollSource
////            ): Offset {
////                val delta = available.y
////                val newOffset = headerOffset + delta
////                headerOffset = newOffset.coerceIn(-maxOffsetPx, 0f)
////                return Offset.Zero
////            }
////        }
////    }
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        // Background content
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxSize()
//                .nestedScroll(nestedScrollConnection)
//        ) {
//            items(30) { index ->
//                Text(
//                    text = "Item $index",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp),
//                    fontSize = 18.sp
//                )
//            }
//        }
//
//        // Top header
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(maxHeaderHeight)
//                .offset { androidx.compose.ui.unit.IntOffset(0, headerOffset.toInt()) }
//                .background(MaterialTheme.colorScheme.primary)
//                .zIndex(1f)
//        ) {
//            Text(
//                text = "Playlist of the Day",
//                color = Color.White,
//                fontSize = 24.sp,
//                modifier = Modifier
//                    .align(Alignment.Center)
//            )
//        }
//    }
//}
