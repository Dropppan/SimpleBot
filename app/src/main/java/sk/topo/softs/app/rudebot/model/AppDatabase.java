package sk.topo.softs.app.rudebot.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import sk.topo.softs.app.rudebot.model.ChatMessage;
import sk.topo.softs.app.rudebot.model.ChatMessageDao;

/**
 * Created by Fanthomo on 27.5.2017.
 */

@Database(entities = {ChatMessage.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract ChatMessageDao chatMessageDao();
}