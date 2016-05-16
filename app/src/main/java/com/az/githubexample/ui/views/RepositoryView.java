package com.az.githubexample.ui.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.az.githubexample.R;
import com.az.githubexample.database.GitRepository;
import com.az.githubexample.interfaces.ViewModel;

import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * Created: Zorin A.
 * Date: 015 15.05.16.
 */
public class RepositoryView extends RelativeLayout implements ViewModel<GitRepository> {

    @Bind(R.id.view_repository_name_text)
    TextView mRepositoryName;

    public RepositoryView(Context context) {
        super(context);
        init();
    }

    public RepositoryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RepositoryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public RepositoryView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    public void setData(GitRepository data) {
        mRepositoryName.setText(data.getName());
    }

    private void init() {
        View view = inflate(getContext(), R.layout.view_repository, this);
        ButterKnife.bind(view);
    }
}
