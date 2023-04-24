package com.debbie.androidxnsupport

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalPagerApi::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val container = findViewById<RelativeLayout>(R.id.container)
        val composeView = ComposeView(this@MainActivity)
        composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val pagerState = rememberPagerState()
                // In Compose world
                MaterialTheme {
                    Row(Modifier.fillMaxSize()) {
                        HorizontalPager(
                            count = 10,
                            state = pagerState,
                            modifier = Modifier.fillMaxWidth(),
                        ) { page ->
                            PagerSampleItem(
                                page = page,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }

                }
            }
        }
        container.addView(composeView, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
    }
}