package sk.topo.softs.app.rudebot.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import sk.topo.softs.app.rudebot.DatabaseInstance;
import sk.topo.softs.app.rudebot.model.ChatMessage;

/**
 * Created by Fanthomo on 27.5.2017.
 */

public class ChatMessageRepository {
    protected LiveData<List<ChatMessage>> messages;


    public ChatMessageRepository() {
        messages = DatabaseInstance.get().chatMessageDao().loadAll();
    }

    public LiveData<List<ChatMessage>> getMessages() {
        return messages;
    }
}
