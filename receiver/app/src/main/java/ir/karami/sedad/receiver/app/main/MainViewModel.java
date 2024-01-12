package ir.karami.sedad.receiver.app.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ir.karami.sadad.receiver.domain.CacheData;
import ir.karami.sadad.receiver.domain.Repository;

public class MainViewModel extends ViewModel {
    public static class State {
        public State(List<ItemState> itemStates) {
            this.itemStates = itemStates;
        }
        public List<ItemState> itemStates;

        public static class ItemState {
            public ItemState(String value, boolean isSynced,int id) {
                this.isSynced = isSynced;
                this.value = value;
                this.id = id;
            }

            public int getId() {
                return id;
            }

            public String getValue() {
                return value;
            }

            public boolean isSynced() {
                return isSynced;
            }

            String value;
            boolean isSynced;

            int id;
        }
    }

    private MutableLiveData<State> _state = new  MutableLiveData<>();
    public LiveData<State> state = _state;
    Repository repository;
    @Inject
    public MainViewModel(Repository repository) {
        this.repository = repository;
        repository.getCachedValues()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .distinctUntilChanged()
                .doOnNext( data -> {
                    _state.postValue(mapper(data));
                })
                .subscribe();
    }

    private State mapper(List<CacheData> cacheDataList) {
        List<State.ItemState> itemStates = new ArrayList<>();
        cacheDataList.forEach(data -> {
            itemStates.add(new State.ItemState(data.value, data.isSent, data.id));
        });

        return new State(itemStates);
    }
}
