package ir.karami.sadadtest.app.di;

import dagger.Component;
import ir.karami.sadadtest.MainActivity;

@Component
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
}
