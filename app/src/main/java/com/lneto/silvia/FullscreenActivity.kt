package com.lneto.silvia

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.WindowManager
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class FullscreenActivity : AppCompatActivity() {


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val webView = findViewById<WebView>(R.id.webview)

        val swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.swiperefresh)

        webView.settings.javaScriptEnabled = true
        webView.settings.forceDark = WebSettings.FORCE_DARK_ON
        webView.loadUrl("http://192.168.68.105:8080")
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        swipeRefreshLayout.setOnRefreshListener {
            webView.reload()
            swipeRefreshLayout.isRefreshing = false
        }
    }
}