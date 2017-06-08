package sk.topo.softs.app.rudebot.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Fanthomo on 27.5.2017.
 */
@Entity(tableName = "chatmessage")
public class ChatMessage {
    @PrimaryKey(autoGenerate = true)
    private int id;
    protected String message;
    protected boolean isHuman;

    public ChatMessage(String message, boolean isHuman) {
        this.message = message;
        this.isHuman = isHuman;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }
}
