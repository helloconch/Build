import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.jetpack.lifecycle.presenter.BasePresenter;
import com.android.jetpack.lifecycle.presenter.IPresenter;

public class A extends AppCompatActivity {
    private IPresenter pre;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pre=new BasePresenter();
    }
}
