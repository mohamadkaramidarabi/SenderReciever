package ir.karami.sedad.receiver.app.main.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import ir.karami.sedad.receiver.app.main.MainViewModel;

public class ItemDiffUtilCallBack extends DiffUtil.ItemCallback<MainViewModel.State.ItemState> {
    @Override
    public boolean areItemsTheSame(@NonNull MainViewModel.State.ItemState oldItem, @NonNull MainViewModel.State.ItemState newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull MainViewModel.State.ItemState oldItem, @NonNull MainViewModel.State.ItemState newItem) {
        return oldItem.isSynced() == newItem.isSynced();
    }
}
