package sk.topo.softs.app.rudebot.adapter;

import android.arch.lifecycle.LiveData;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sk.topo.softs.app.rudebot.R;
import sk.topo.softs.app.rudebot.model.ChatMessage;

/**
 * Created by Fanthomo on 27.5.2017.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    //protected LiveData<List<ChatMessage>> messages;
    protected List<ChatMessage> messages;


    public MessageAdapter(LiveData<List<ChatMessage>> messages) {
        //this.messages = messages;
    }

    public MessageAdapter() {
        messages = new ArrayList<>();

    }

    public void addMessage(ChatMessage message) {
        messages.add(message);
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_message_item, null);
        return new MessageViewHolder(linearLayout);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        ChatMessage m = messages.get(position);
        holder.message.setText(m.getMessage());
        holder.message.setBackgroundColor(m.isHuman() ? Color.GREEN : Color.GRAY);
    }

    @Override
    public int getItemCount() {
        /*if (messages.getValue() == null) {
            return 0;
        }*/
        return messages.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        TextView message;

        public MessageViewHolder(View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.messageView);
        }
    }


}
