package sk.topo.softs.app.rudebot.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;

import java.util.ArrayList;
import java.util.List;

import sk.topo.softs.app.rudebot.DatabaseInstance;
import sk.topo.softs.app.rudebot.adapter.MessageAdapter;
import sk.topo.softs.app.rudebot.core.WordProcessor;
import sk.topo.softs.app.rudebot.model.ChatMessage;
import sk.topo.softs.app.rudebot.repository.ChatMessageRepository;

/**
 * Created by Fanthomo on 27.5.2017.
 */

public class MainViewModel extends ViewModel {

    protected String messageDraft = new String();
    //protected LiveData<List<ChatMessage>> messages;
    protected MessageAdapter adapter;
    protected WordProcessor processor;

    protected ChatMessageRepository repository;

    public MainViewModel() {
        //messages = DatabaseInstance.get().chatMessageDao().loadAll();
        processor = new WordProcessor();
    }

    public String getMessageDraft() {
        return messageDraft;
    }

    public void setMessageDraft(String messageDraft) {
        this.messageDraft = messageDraft;
    }

    public void sendMessage(final String text) {
        /*DatabaseInstance.get().chatMessageDao().save(new ChatMessage(text, true));
        adapter.getItemCount();
        //*///List<ChatMessage> m = DatabaseInstance.get().chatMessageDao().loadAllNow();
        adapter.addMessage(new ChatMessage(text, true));
        adapter.addMessage(new ChatMessage(processor.getResponseOnMessage(text), false));

    }

    public MessageAdapter getAdapter() {
        if (adapter == null) {
            adapter = new MessageAdapter();
        }
        return adapter;
    }
}
