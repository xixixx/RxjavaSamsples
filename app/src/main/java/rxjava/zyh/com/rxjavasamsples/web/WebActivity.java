package rxjava.zyh.com.rxjavasamsples.web;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import rxjava.zyh.com.rxjavasamsples.R;
import rxjava.zyh.com.rxjavasamsples.statusbar.StatusBarCompat;

/**
 * @author 占迎辉 (zhanyinghui@parkingwang.com)
 * @version 2017/8/4
 */

public class WebActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(R.layout.activity_web);
        StatusBarCompat.setStatusBarColor(this,R.color.ThemeColor);
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setWebChromeClient(new CoolWebChromeClient());
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("file:///android_asset/test.html");
    }


}

