package sk.topo.softs.app.rudebot;

import android.arch.persistence.room.Room;
import android.content.Context;

import sk.topo.softs.app.rudebot.model.AppDatabase;

/**
 * Created by Fanthomo on 27.5.2017.
 */

public class DatabaseInstance {

    private static final String DB_NAME = "rudebot_db";

    private static AppDatabase INSTANCE;

    public static AppDatabase get() {
        return INSTANCE;
    }


    public static void init(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, DB_NAME).build();
        }
    }
}
