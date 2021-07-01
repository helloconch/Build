package com.example.android.testinstall;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;

import android.os.Environment;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.versionCode);
        textView.setText("version:" + BuildConfig.VERSION_NAME);

        findViewById(R.id.download).setOnClickListener(v -> {
            test(MainActivity.this, true, false, false);
        });

        findViewById(R.id.outer).setOnClickListener(v -> {
            test(MainActivity.this, false, true, false);
        });
        findViewById(R.id.inner).setOnClickListener(v -> {
            test(MainActivity.this, false, false, true);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void test(Context context, boolean download, boolean outer, boolean inner) {

        //Download目录 targetSdkVersion=22可访问  targetSdkVersion=28未申请权限时，只可访问自己app的路径
        File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        //内部存储data/user/0/
        if (inner) {
            directory = context.getFilesDir();
        }
        //外部存储storage/emulated/0/Android/data/
        if (outer) {
            directory = context.getExternalFilesDir(null);
        }
        File file = new File(directory.getPath() + "/app-upgrade.apk");
        Log.i("AABBCCDD", "文件:" + file.getPath());
        if (file.exists()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri contentUri;
            boolean state = true;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && state) {
                contentUri = FileProvider.getUriForFile(context, context.getPackageName() + ".FileProvider", file);
                Log.i("AABBCCDD", "有FileProvider:" + contentUri.getEncodedPath());
            } else {
                contentUri = Uri.fromFile(file);
                Log.i("AABBCCDD", "无FileProvider:" + contentUri.getEncodedPath());
            }

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && state) {
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            }
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
            context.startActivity(intent);
        } else {
            Log.i("AABBCCDD", "不存在文件:" + file.getPath());
        }
    }
}