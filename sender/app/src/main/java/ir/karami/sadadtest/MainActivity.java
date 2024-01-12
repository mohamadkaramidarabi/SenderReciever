package ir.karami.sadadtest;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.util.Objects;

import ir.karami.sadad.common.model.Constants;
import ir.karami.sadadtest.app.App;
import ir.karami.sadadtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplicationContext()).appComponent.inject(this);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.btn.setOnClickListener( v -> {
            Intent intent = new Intent(Constants.RECEIVER_ACTION_NAME);
            intent.putExtra(Constants.STRING_KEY, Objects.requireNonNull(binding.edt.getText()).toString());
            sendBroadcast(intent);
        });
    }
}