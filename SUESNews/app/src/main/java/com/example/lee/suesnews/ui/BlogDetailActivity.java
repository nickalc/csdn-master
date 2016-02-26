package com.example.lee.suesnews.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.lee.csdn.R;

/**
 * Author:  nick
 * Email:   nickdevp@gmail.com
 * Date:    15/11/16 16:46.
 * Description:
 */
public class BlogDetailActivity extends BaseActivity{

    private String mNewsContentUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_detail);

        //通过bundle获取文章内容的url
        mNewsContentUrl = this.getIntent().getBundleExtra("key").getString("url");

        init();
    }


    private void init(){
        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_18dp));
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlogDetailActivity.this.finish();
            }
        });

        WebView myWebView = (WebView) findViewById(R.id.blog_webview);
        myWebView.getSettings().setSupportZoom(true);
        myWebView.getSettings().setBuiltInZoomControls(false);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);

        myWebView.setWebViewClient(new WebViewClient() {

            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return true;
            }
        });
         myWebView.loadUrl(mNewsContentUrl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news_content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            String title = null;
            String url = null;
//            if(mNewsContent != null){
//                title = mNewsContent.getTitle();
//                url = mNewsContent.getUrl();
//            }
            showShare(this, title +" 详见：" + url +" \n分享自CSDN技术博客： http://fir.im/sues");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
