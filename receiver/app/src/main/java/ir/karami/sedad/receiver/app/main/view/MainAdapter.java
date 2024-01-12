package ir.karami.sedad.receiver.app.main.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.ListAdapter;

import ir.karami.sedad.receiver.app.R;
import ir.karami.sedad.receiver.app.main.MainViewModel;

public class MainAdapter extends ListAdapter<MainViewModel.State.ItemState, ItemViewHolder> {

    LifecycleOwner lifecycleOwner;
    public MainAdapter(LifecycleOwner lifecycleOwner) {
        super(new ItemDiffUtilCallBack());
        this.lifecycleOwner = lifecycleOwner;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item,
                        parent,
                        false), lifecycleOwner
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(getItem(position));
    }
}
