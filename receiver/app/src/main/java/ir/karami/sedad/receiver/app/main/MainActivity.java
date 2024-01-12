package ir.karami.sedad.receiver.app.main;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import javax.inject.Inject;

import ir.karami.sedad.receiver.app.App;
import ir.karami.sedad.receiver.app.R;
import ir.karami.sedad.receiver.app.databinding.ActivityMainBinding;
import ir.karami.sedad.receiver.app.main.view.MainAdapter;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel viewModel;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((App) getApplicationContext()).appComponent.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        MainAdapter adapter = new MainAdapter(this);
        binding.iv.setLayoutManager(new LinearLayoutManager(this));
        binding.iv.setAdapter(adapter);
        viewModel.state.observe(this, state -> {
            binding.setState(state);
            adapter.submitList(state.itemStates,() -> {
                Log.d("submitList",state.itemStates.size() + " done");
            });
        });
    }
}