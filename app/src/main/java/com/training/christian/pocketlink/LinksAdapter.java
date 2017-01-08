package com.training.christian.pocketlink;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LinksAdapter extends RecyclerView.Adapter<LinksAdapter.LinkViewHolder> {

    private List<Link> mLinks;

    public LinksAdapter(List<Link> mLinks) {
        this.mLinks = mLinks;
    }

    @Override
    public LinkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View rowView = inflater.inflate(R.layout.row_pocket_item, parent, false);
        return new LinkViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(LinkViewHolder holder, int position) {
        Link item = mLinks.get(position);

        holder.mLinkTitle.setText(item.getName());
        holder.mLinkReference.setText(item.getReference());
        if (item.getType()==Link.TYPE_PHONE){
            holder.mLnkSymbol.setImageResource(android.R.drawable.ic_menu_call);
        }
        else if (item.getType() == Link.TYPE_LINK){
            holder.mLnkSymbol.setImageResource(android.R.drawable.ic_menu_search);

        }
    }

    @Override
    public int getItemCount() {
        return mLinks.size();
    }

    public class LinkViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.link_title)
        TextView mLinkTitle;
        @BindView(R.id.link_reference)
        TextView mLinkReference;
        @BindView(R.id.link_symbol)
        ImageView mLnkSymbol;

        public LinkViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
