package com.example.myapplication

import android.os.Build
import android.os.Bundle
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var webView: WebView = findViewById(R.id.webView)

        webView.getSettings().setJavaScriptEnabled(true)
        webView.getSettings().setLoadWithOverviewMode(true)
        webView.getSettings().setUseWideViewPort(true)
        webView.getSettings().setBuiltInZoomControls(true)
        webView.getSettings().setPluginState(WebSettings.PluginState.ON)
//        webView.getSettings().setPluginsEnabled(true)
        val settings = webView.settings
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        settings.javaScriptEnabled = true

        settings.cacheMode = WebSettings.LOAD_NO_CACHE
        settings.databaseEnabled = false
        settings.domStorageEnabled = false
        settings.setGeolocationEnabled(false)
        settings.saveFormData = false
        webView.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");


        webView.settings.loadsImagesAutomatically = true
        webView.settings.javaScriptEnabled = true
        webView.settings.allowContentAccess = true

//        webView.loadUrl(url)

//        webView.settings.useWideViewPort = true
//        webView.settings.loadWithOverviewMode = true
        webView.settings.domStorageEnabled = true
//        webView.clearView()
//        webView.isHorizontalScrollBarEnabled = false
////        webView.settings.setAppCacheEnabled(true)
//        webView.settings.databaseEnabled = true
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
//            webView.settings.databasePath = "/data/data/" + this.packageName + "/databases/"
//        }
//        webView.isVerticalScrollBarEnabled = false
//        webView.settings.builtInZoomControls = true
//        webView.settings.displayZoomControls = false
//        webView.settings.allowFileAccess = true
//        webView.settings.pluginState = WebSettings.PluginState.OFF
//        webView.isScrollbarFadingEnabled = false
//        webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
//        webView.settings.defaultZoom = WebSettings.ZoomDensity.FAR
//        webView.webViewClient = WebViewClient()
//        webView.settings.setRenderPriority(WebSettings.RenderPriority.HIGH)
//        webView.setInitialScale(1)


        webView.setWebViewClient(HelloWebViewClient())
        webView.webChromeClient = HelloWebChromeClient()
        webView.loadUrl("https://d1mtg6picedtk1.cloudfront.net/mcms-apps-apk/temp/tarun_bharat.html")
    }
    private class HelloWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return false
        }
    }
    private class HelloWebChromeClient : WebChromeClient() {
        override fun onPermissionRequest(request: PermissionRequest?) {
            val resources = request?.resources
            for (i in resources?.indices!!) {
                if (PermissionRequest.RESOURCE_PROTECTED_MEDIA_ID == resources[i]) {
                    request.grant(resources)
                    return
                }
            }
            super.onPermissionRequest(request)
        }
    }

}