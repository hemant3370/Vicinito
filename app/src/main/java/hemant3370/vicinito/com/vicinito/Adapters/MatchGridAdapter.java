package hemant3370.vicinito.com.vicinito.Adapters;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import hemant3370.vicinito.com.vicinito.Models.Stream.Stream;
import hemant3370.vicinito.com.vicinito.R;


/**
 * Created by HemantSingh on 25/10/16.
 */

public class MatchGridAdapter extends RecyclerView.Adapter<MatchGridAdapter.ViewHolder> {

    private List<Stream> mFileset;
    private final Context context;

    CustomItemClickListener listener;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        @Bind(R.id.titletv) TextView titleTV;
        @Bind(R.id.descriptiontv) TextView descriptionTV;
        @Bind(R.id.authornametv) TextView authorTV;
        @Bind(R.id.heartcount) TextView heartCountTV;
        @Bind(R.id.sharecount) TextView shareCountTV;
        @Bind(R.id.shareiv)
        ImageButton shareButton;
        @Bind(R.id.authoriv) ImageView authorIV;
        @Bind(R.id.ivProfile) ImageView imgageView;


        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }


    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MatchGridAdapter(Context context, List<Stream> fileSet, CustomItemClickListener listener) {

        this.listener = listener;
        this.context = context;
        mFileset = fileSet;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {


            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.feeditem, parent, false);
            // set the view's size, margins, paddings and layout parameters

            final ViewHolder vh = new ViewHolder(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v, vh.getAdapterPosition());
                }
            });
            vh.shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemShare(v, vh.getAdapterPosition());
                }
            });
            return vh;


    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Stream stream = mFileset.get(position);
        if (stream != null && stream.getUser() != null) {
            holder.titleTV.setText(nullCheck(stream.getTitle()));
            Spanned result;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                result = Html.fromHtml(nullCheck(stream.getHtmlDescription()), Html.FROM_HTML_MODE_LEGACY);
            } else {
                result = Html.fromHtml(nullCheck(stream.getHtmlDescription()));
            }
            holder.descriptionTV.setText(result);
            holder.authorTV.setText(nullCheck(stream.getUser().getName()));
            holder.shareCountTV.setText(nullCheck(stream.getSocial().getShares().toString()));
            holder.heartCountTV.setText(nullCheck(stream.getSocial().getLikes().toString()));
            Glide.with(context).load(nullCheck(stream.getUser().getThumbnail())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(holder.authorIV);
            Glide.with(context).load(nullCheck(stream.getMedia().getUrl())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().fitCenter().listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    holder.imgageView.setImageDrawable(resource);
                    return false;
                }
            })
                    .into(holder.imgageView);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return mFileset.size();
    }
public String nullCheck(String str){
    if (str != null) {
     return  str;
    }
    return "";
}

}



