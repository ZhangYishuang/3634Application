package com.example.shuhao20.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ChapterLearning extends AppCompatActivity {
    private WebView mWv;
    private int position;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_learning);
        mWv = findViewById(R.id.wv);
        intent = getIntent();
        position = intent.getIntExtra("pos", 0);

        //Enable JavaScript
        mWv.getSettings().setJavaScriptEnabled(true);
        mWv.setWebViewClient(new MyWebViewClient());
        mWv.setWebChromeClient(new MyWebChromeClient());
        mWv.canGoBack();
        switchChapterUrl(mWv, position);
        setFullScreenNoStatusBar(this);
    }

    class MyWebViewClient extends WebViewClient {
        //Do not Open URL by Outside App
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            //view.loadUrl(request.getUrl().toString());
            //Disable hyperlink
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            //Set title into loading when started
            setTitle("Loading...");
            Log.d("WebView", "onPageStarted...");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            setChapterTitle(position);
            Log.d("WebView","onPageFinished...");
        }
    }

    // Setting Back Key
    // Website goes back when it can go back
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && mWv.canGoBack()) {
            mWv.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    class MyWebChromeClient extends WebChromeClient{
        //When page on progress
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
        //Set title
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }
    }

    //Switch Chapter Url
    public void switchChapterUrl(WebView webView, int pos) {
        switch(pos) {
            case 0:
                webView.loadUrl("http://www.corejavaguru.com/java/basic/overview");
                break;
            case 1:
                webView.loadUrl("http://www.corejavaguru.com/java/basic/settingjava");
                break;
            case 2:
                webView.loadUrl("http://www.corejavaguru.com/java/basic/basicjava");
                break;
            case 3:
                webView.loadUrl("http://www.corejavaguru.com/java/basic/variables");
                break;
            case 4:
                webView.loadUrl("http://www.corejavaguru.com/java/basic/arrays");
                break;
            case 5:
                webView.loadUrl("http://www.corejavaguru.com/java/basic/controlstatements");
                break;
            case 6:
                webView.loadUrl("http://www.corejavaguru.com/java/basic/methods");
                break;
            case 7:
                webView.loadUrl("http://www.corejavaguru.com/java/strings/strings");
                break;
            case 8:
                webView.loadUrl("http://www.corejavaguru.com/java/oop/class-object");
                break;
            case 9:
                webView.loadUrl("http://www.corejavaguru.com/java/oop/constructor");
                break;
            case 10:
                webView.loadUrl("http://www.corejavaguru.com/java/oop/4pillars");
                break;
            case 11:
                webView.loadUrl("http://www.corejavaguru.com/java/oop/abstraction");
                break;
            case 12:
                webView.loadUrl("http://www.corejavaguru.com/java/oop/encapsulation");
                break;
            case 13:
                webView.loadUrl("http://www.corejavaguru.com/java/oop/inheritance");
                break;
            case 14:
                webView.loadUrl("http://www.corejavaguru.com/java/oop/polymorphism");
                break;
            case 15:
                webView.loadUrl("http://www.corejavaguru.com/java/exceptions/exception-handling");
                break;
            case 16:
                webView.loadUrl("https://www.tutorialspoint.com/compile_java_online.php");
                break;
        }
    }

    public void setChapterTitle(int position) {
        switch(position) {
            case 0:
                setTitle("Chapter 1 | Java Overview");
                break;
            case 1:
                setTitle("Chapter 2 | Setting Java Environment");
                break;
            case 2:
                setTitle("Chapter 3 | Basic Java Syntax");
                break;
            case 3:
                setTitle("Chapter 4 | Variable & Data Type");
                break;
            case 4:
                setTitle("Chapter 5 | Arrays");
                break;
            case 5:
                setTitle("Chapter 6 | Control Statements");
                break;
            case 6:
                setTitle("Chapter 7 | Methods");
                break;
            case 7:
                setTitle("Chapter 8 | Strings");
                break;
            case 8:
                setTitle("Chapter 9 | Java OOP");
                break;
            case 9:
                setTitle("Chapter 10 | Constructors");
                break;
            case 10:
                setTitle("Chapter 11 | 4 pillars");
                break;
            case 11:
                setTitle("Chapter 12 | Abstraction");
                break;
            case 12:
                setTitle("Chapter 13 | Encapsulation");
                break;
            case 13:
                setTitle("Chapter 14 | Inheritance");
                break;
            case 14:
                setTitle("Chapter 15 | Polymorphism");
                break;
            case 15:
                setTitle("Chapter 16 | Java Exception Handling");
                break;
        }
    }
    //Full screen without status bar
    public static void setFullScreenNoStatusBar(Activity activity) {
        activity.getWindow().
                setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
