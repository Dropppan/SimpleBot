package sk.topo.softs.app.rudebot.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Fanthomo on 27.5.2017.
 */

@Dao
public interface ChatMessageDao {

    @Insert(onConflict = REPLACE)
    void save(ChatMessage message);

    @Query("SELECT * FROM chatmessage")
    LiveData<List<ChatMessage>> loadAll();

    @Query("SELECT * FROM chatmessage")
    List<ChatMessage> loadAllNow();
}
