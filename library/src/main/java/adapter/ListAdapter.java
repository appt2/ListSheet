package com.ninjacoder.listshset.library.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import static android.view.View.GONE;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ninjacoder.listshset.library.R;
import com.ninjacoder.listshset.library.model.SheetModel;
import com.ninjacoder.listshset.library.interfaces.OnItemClickEvent;
import java.util.List;

public class ListAdapter extends BaseAdapter implements Adapter {
  protected List<SheetModel> model;
  private int colorText = Color.WHITE;
  private int colorFilter = Color.WHITE;
  private LinearLayout root;
  protected ImageView img;
  protected TextView tv;
  public ListAdapter(List<SheetModel> model) {
    this.model = model;
    
  }

  @Override
  public int getCount() {
    return model.size();
  }

  @Override
  public SheetModel getItem(int id) {
    return model.get(id);
  }

  @Override
  public long getItemId(int arg0) {
    return arg0;
  }

  @Override
  public View getView(int pos, View views, ViewGroup par) {
    views = LayoutInflater.from(par.getContext()).inflate(R.layout.layout_adapter, par, false);
    var sheet = model.get(pos);
     root = views.findViewById(R.id.root);
     img = views.findViewById(R.id.icon);
     tv = views.findViewById(R.id.name);
    if (sheet.getIcon() == 0) {
      img.setVisibility(GONE);
    }
    img.setImageResource(sheet.getIcon());
    tv.setText(sheet.getName());
    root.setEnabled(!sheet.getIsItem());
    root.setAlpha(!sheet.getIsItem() ? 0.4f : 1f);
    tv.setTextColor(colorText);
    img.setColorFilter(colorFilter ,PorterDuff.Mode.SRC_IN);
    return views;
  }
  public void setTextColor(int color){
    this.colorText = color;
  }
  public void setColorFilter(int colorFilter){
    this.colorFilter = colorFilter;
  }
  
}
