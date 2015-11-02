package eu.kanade.mangafeed.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.kanade.mangafeed.R;
import eu.kanade.mangafeed.data.models.Chapter;
import eu.kanade.mangafeed.ui.fragment.base.BaseFragment;
import eu.kanade.mangafeed.ui.holder.ChaptersHolder;

public class ChaptersAdapter extends FlexibleAdapter<ChaptersHolder, Chapter> {

    private Context context;
    public OnItemClickListener clickListener;

    public ChaptersAdapter(BaseFragment fragment) {
        this.context = fragment.getActivity();
        mItems = new ArrayList<>();
        clickListener = (OnItemClickListener) fragment;
    }

    @Override
    public void updateDataSet(String param) {}

    @Override
    public ChaptersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_chapter, parent, false);
        return new ChaptersHolder(v, this);
    }

    @Override
    public void onBindViewHolder(ChaptersHolder holder, int position) {
        final Chapter chapter = getItem(position);
        holder.onSetValues(context, chapter);
    }

    public void setItems(List<Chapter> chapters) {
        mItems = chapters;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        boolean onListItemClick(int position);
        void onListItemLongClick(int position);
    }
}
