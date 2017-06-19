package sk.topo.softs.app.rudebot.viewmodel;

import android.arch.lifecycle.ViewModel;

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
    protected MessageAdapter adapter;
    protected WordProcessor processor;

    protected ChatMessageRepository repository;

    public MainViewModel() {
        processor = new WordProcessor();
        repository = new ChatMessageRepository();
    }

    public String getMessageDraft() {
        return messageDraft;
    }

    public void setMessageDraft(String messageDraft) {
        this.messageDraft = messageDraft;
    }

    public void sendMessage(final String text) {
        DatabaseInstance.get().chatMessageDao().save(new ChatMessage(text, true));
        DatabaseInstance.get().chatMessageDao().save(new ChatMessage(processor.getResponseOnMessage(text), false));
        adapter.getItemCount();
    }

    public MessageAdapter getAdapter() {
        if (adapter == null) {
            adapter = new MessageAdapter(repository.getMessages());
        }
        return adapter;
    }

    public ChatMessageRepository getRepository() {
        return repository;
    }
}
