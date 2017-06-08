package sk.topo.softs.app.rudebot;

import android.app.Application;

/**
 * Created by Fanthomo on 27.5.2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseInstance.init(getApplicationContext());
    }
}
