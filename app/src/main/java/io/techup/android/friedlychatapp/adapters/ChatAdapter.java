package io.techup.android.friedlychatapp.adapters;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import io.techup.android.friedlychatapp.R;
import io.techup.android.friedlychatapp.pojo.Chat;

/**
 * Created by PaoRendor on 01/08/16.
 */
public class ChatAdapter extends ArrayAdapter {


    private Context mContext;
    private List<Chat> mMessageList;

    public ChatAdapter(Context context, List<Chat> objects) {
        super(context, 0, objects);
        this.mContext = context;
        this.mMessageList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.chat_item, parent, false);

        ImageView userImage = (ImageView) view.findViewById(R.id.iv_img_user);
        TextView userName = (TextView) view.findViewById(R.id.tv_user_name);
        TextView userMessage = (TextView) view.findViewById(R.id.tv_message);
        TextView time = (TextView) view.findViewById(R.id.tv_time);

       Chat message = mMessageList.get(position);
        Glide.with(mContext).load(message.getSenderPhotoUrl()).asBitmap().into(userImage);
        userName.setText(message.getSenderName());
        userMessage.setText(message.getMessage());
        // Convert date to human readable time
        String convertedTime = DateUtils.getRelativeTimeSpanString(message.getTime().getTime(),
                System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        time.setText(convertedTime);

        return view;
    }

    @Override
    public Chat getItem(int position) {
        return mMessageList.get(position);
    }
}
