package ir.karami.sedad.receiver.app.main.view;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import ir.karami.sedad.receiver.app.databinding.ItemBinding;
import ir.karami.sedad.receiver.app.main.MainViewModel;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    ItemBinding binding;
    public ItemViewHolder(@NonNull ItemBinding binding, LifecycleOwner lifecycleOwner) {
        super(binding.getRoot());
        this.binding = binding;
        this.binding.setLifecycleOwner(lifecycleOwner);
    }

    public void onBind(MainViewModel.State.ItemState itemState) {
        binding.setState(itemState);
        binding.executePendingBindings();
    }
}
