package com.orangecaw.android.githubber.presentation.view.ui.timeline.event.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jaeryong.glide.transformation.CircleTransformation;
import com.orangecaw.android.githubber.R;
import com.orangecaw.android.githubber.data.Event;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.DimensionPixelOffsetRes;

import java.util.List;

@EViewGroup(R.layout.received_event_item)
public class ReceivedEventItemView extends FrameLayout {

    @DimensionPixelOffsetRes(R.dimen.event_profile_size)
    int profileSize;

    @ViewById(R.id.event_profile)
    ImageView profile;

    @ViewById(R.id.event_title)
    TextView title;

    @ViewById(R.id.event_time)
    TextView time;

    @ViewById(R.id.event_message)
    TextView message;

    @ViewById(R.id.event_description)
    TextView description;

    public ReceivedEventItemView(Context context) {
        super(context);
    }

    public void bind(Event event) {
        // profile
        Glide.with(getContext())
                .load(event.getActor().getAvatarUrl())
                .asBitmap()
                .animate(android.R.anim.fade_in)
                .transform(new CircleTransformation(getContext()))
                .override(profileSize, profileSize)
                .into(profile);

        // title
        title.setText(event.getActor().getLogin());

        // time
        time.setText(event.getCreatedAt());


//        try {
//            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(event.getCreated_at());
//            Log.d("asdf", "Asdf");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        // message
        List<String> msgs = event.getMessages();
        if(msgs.size() == 1) {
            message.setText(msgs.get(0));
            description.setVisibility(View.GONE);
        } else {
            message.setText(msgs.get(0));
            description.setText(msgs.get(1));
            description.setVisibility(View.VISIBLE);
        }
    }

}
