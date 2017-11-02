package hemant3370.vicinito.com.vicinito.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemant3370.vicinito.com.vicinito.Models.Stream.ItemDetail.Resource;
import hemant3370.vicinito.com.vicinito.R;

/**
 * Created by HemantSingh on 06/12/16.
 */

public class feedDetailAdapter extends RecyclerView.Adapter<feedDetailAdapter.ViewHolder> {

    private List<Resource> mFileset;
    private final Context context;

    CustomItemClickListener listener;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        @BindView(R.id.detailivdesc)
        TextView titleTextView;
        @BindView(R.id.ivdetailitem) ImageView mImageView;


        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }


    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public feedDetailAdapter(Context context, List<Resource> fileSet, CustomItemClickListener listener) {

        this.listener = listener;
        this.context = context;
        Predicate<Resource> isImage = new Predicate<Resource>() {
            @Override
            public boolean apply(Resource input) {
                Log.wtf( "apply: ", String.valueOf(input.getType().contains("image")));
               return input.getType().contains("image");
            }
        };
        this.mFileset = Lists.newArrayList(Iterables.filter(fileSet, isImage).iterator());
    }

    // Create new views (invoked by the layout manager)
    @Override
    public feedDetailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {


        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detailitem, parent, false);
        // set the view's size, margins, paddings and layout parameters

        final feedDetailAdapter.ViewHolder vh = new feedDetailAdapter.ViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, vh.getAdapterPosition());
            }
        });

        return vh;


    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final feedDetailAdapter.ViewHolder holder, int position) {
        Resource stream = mFileset.get(position);
        holder.titleTextView.setText(nullCheck(stream.getCaption()));
        Glide.with(context).load(nullCheck(stream.getUrl())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().fitCenter().listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                holder.mImageView.setImageDrawable(resource);
                return false;
            }
        })
                .into(holder.mImageView);
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



