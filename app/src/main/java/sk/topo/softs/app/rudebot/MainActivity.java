package sk.topo.softs.app.rudebot;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import sk.topo.softs.app.rudebot.model.ChatMessage;
import sk.topo.softs.app.rudebot.viewmodel.MainViewModel;

@EActivity(R.layout.activity_main)
public class MainActivity extends LifecycleActivity {

    @ViewById
    protected EditText inputEditText;
    @ViewById
    protected RecyclerView chatRecyclerView;

    protected MainViewModel viewModel;
    LinearLayoutManager manager;

    @AfterViews
    protected void init() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        inputEditText.setText(viewModel.getMessageDraft());
        inputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                viewModel.setMessageDraft(s.toString());
            }
        });
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        manager.setSmoothScrollbarEnabled(true);
        chatRecyclerView.setLayoutManager(manager);
        chatRecyclerView.setAdapter(viewModel.getAdapter());
        viewModel.getRepository().getMessages().observe(this, new Observer<List<ChatMessage>>() {
            @Override
            public void onChanged(@Nullable List<ChatMessage> chatMessages) {
                Toast.makeText(MainActivity.this, "messages: " + chatMessages.size(), Toast.LENGTH_SHORT).show();
                chatRecyclerView.getAdapter().notifyDataSetChanged();
            }
        });
    }

    @Click(R.id.sendButton)
    protected void sendMessage() {
        processSending(inputEditText.getText().toString());
        inputEditText.setText("");
    }

    @Background
    protected void processSending(String text) {
        viewModel.sendMessage(text);
        invalidateRecycler();
    }

    @UiThread
    protected void invalidateRecycler() {
        chatRecyclerView.requestLayout();
        manager.smoothScrollToPosition(chatRecyclerView, null, chatRecyclerView.getAdapter().getItemCount());
    }
}
