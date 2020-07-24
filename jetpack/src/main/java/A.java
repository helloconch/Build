import android.content.MutableContextWrapper;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import com.android.jetpack.lifecycle.presenter.BasePresenter;
import com.android.jetpack.lifecycle.presenter.IPresenter;

public class A extends AppCompatActivity {
    private IPresenter pre;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      String a=String.valueOf("a");
    }
}
