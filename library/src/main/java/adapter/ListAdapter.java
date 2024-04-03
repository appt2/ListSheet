package com.ninjacoder.listshset.library.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import static android.view.View.GONE;
import android.widget.Adapter;
import androidx.recyclerview.widget.RecyclerView;

import com.ninjacoder.listshset.library.R;
import com.ninjacoder.listshset.library.interfaces.OnItemClickEvent;
import com.ninjacoder.listshset.library.model.SheetModel;

import com.ninjacoder.listshset.library.widget.AnimatorUtils;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.VH> {

  private List<SheetModel> model;
  private int colorText = Color.WHITE;
  private int colorFilter = Color.WHITE;
  protected OnItemClickEvent ev;
  protected boolean isAnim = false;
  protected boolean isLayout2 = false;

  public ListAdapter(List<SheetModel> model, OnItemClickEvent ev) {
    this.model = model;
    this.ev = ev;
  }

  @Override
  public VH onCreateViewHolder(ViewGroup parent, int viewType) {
    var view =
        LayoutInflater.from(parent.getContext())
            .inflate(isLayout2 ? R.layout.layout_adapter2 : R.layout.layout_adapter, parent, false);
    return new VH(view);
  }

  @Override
  public void onBindViewHolder(VH holder, int position) {
    SheetModel sheet = model.get(position);

    if (sheet.getIcon() == 0) {
      holder.img.setVisibility(View.GONE);
    } else {
      holder.img.setVisibility(View.VISIBLE);
      holder.img.setImageResource(sheet.getIcon());
    }

    holder.tv.setText(sheet.getName());

    holder.root.setAlpha(sheet.getIsItem() ? 1f : 0.4f);
    holder.tv.setTextColor(colorText);
    holder.img.setColorFilter(colorFilter, PorterDuff.Mode.SRC_IN);
    if (ev != null) {
      holder.root.setOnClickListener(
          c -> {
            if (sheet.getIsItem()) {
              ev.onClickItem(holder.getAdapterPosition());
              if (isAnim) AnimatorUtils.ClickAnimation(holder.root);
            }
            holder.root.setOnLongClickListener(
                ___ -> {
                  if (sheet.getIsItem()) {
                    ev.onClickItem(holder.getAdapterPosition());
                    if (isAnim) ev.onLongItem(holder.getAdapterPosition());
                  }
                  return true;
                });
          });
    }
  }

  @Override
  public int getItemCount() {
    return model.size();
  }

  public void setTextColor(int color) {
    this.colorText = color;
  }

  public void setColorFilter(int colorFilter) {
    this.colorFilter = colorFilter;
  }

  public void setAnimatorItem(boolean is) {
    this.isAnim = is;
  }

  public void setLayoutChange(boolean isLayout2) {
    this.isLayout2 = isLayout2;
  }


  static class VH extends RecyclerView.ViewHolder {
    private LinearLayout root;
    private ImageView img;
    private TextView tv;

    public VH(View itemView) {
      super(itemView);
      root = itemView.findViewById(R.id.root);
      img = itemView.findViewById(R.id.icon);
      tv = itemView.findViewById(R.id.name);
    }
  }
}
