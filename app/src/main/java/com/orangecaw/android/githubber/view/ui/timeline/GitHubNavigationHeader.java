package com.orangecaw.android.githubber.view.ui.timeline;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jaeryong.glide.transformation.CircleTransformation;
import com.orangecaw.android.githubber.R;
import com.orangecaw.android.githubber.data.User;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.DimensionPixelOffsetRes;

@EViewGroup(R.layout.github_nav_header)
public class GitHubNavigationHeader extends LinearLayout {

    @DimensionPixelOffsetRes(R.dimen.nav_header_profile_size)
    int profileThumbSize;

    @ViewById(R.id.github_nav_header_profile)
    ImageView profileThumb;

    @ViewById(R.id.github_nav_header_user)
    TextView username;

    @ViewById(R.id.github_nav_header_email)
    TextView email;

    public GitHubNavigationHeader(Context context) {
        super(context);
    }

    public void bindProfile(User user) {
        Glide.with(getContext())
                .load(user.getAvatarUrl())
                .asBitmap()
                .centerCrop()
                .transform(new CircleTransformation(getContext()))
                .animate(android.R.anim.fade_in)
                .override(profileThumbSize, profileThumbSize)
                .into(profileThumb);

        username.setText(!TextUtils.isEmpty(user.getName()) ? user.getName() : user.getLogin());

        email.setText(!TextUtils.isEmpty(user.getEmail()) ? user.getEmail() : "");
    }

}
