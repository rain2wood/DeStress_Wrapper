package xyz.smsoss.destress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        WebView webView = (WebView) findViewById(R.id.webview);

        // run everything inside app
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        WebSettings w = webView.getSettings();
        w.setJavaScriptEnabled(true);
        w.setMediaPlaybackRequiresUserGesture(false);
        w.setUseWideViewPort(true);
        w.setLoadWithOverviewMode(true);
        w.setSupportZoom(true);
        w.setBuiltInZoomControls(true);
        w.setDisplayZoomControls(false);
        webView.clearCache(true);
        webView.setInitialScale(90);
        webView.loadUrl("http://192.168.50.171:8080");
    }
}