package hemant3370.vicinito.com.vicinito.Dagger.Component;


import javax.inject.Singleton;

import dagger.Component;
import hemant3370.vicinito.com.vicinito.Activities.DetailActivity;
import hemant3370.vicinito.com.vicinito.Activities.MainActivity;
import hemant3370.vicinito.com.vicinito.Activities.TopicsActivity;
import hemant3370.vicinito.com.vicinito.Dagger.Module.AppModule;
import hemant3370.vicinito.com.vicinito.Dagger.Module.NetModule;


/**
 * Created by Rahul on 6/20/2016.
 */
@Singleton
@Component(modules = {NetModule.class, AppModule.class})
public interface NetComponent {

    void inject(MainActivity activity);
    void inject(DetailActivity activity);
    void inject(TopicsActivity activity);























}
