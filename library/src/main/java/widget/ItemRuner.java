package com.ninjacoder.listshset.library.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.divider.MaterialDivider;
import com.ninjacoder.listshset.library.R;
import com.ninjacoder.listshset.library.adapter.ListAdapter;
import com.ninjacoder.listshset.library.interfaces.OnItemClickEvent;
import com.ninjacoder.listshset.library.model.SheetModel;
import java.util.ArrayList;
import java.util.List;

public class ItemRuner {
  protected Context context;

  protected RecyclerView listview;
  protected List<SheetModel> list = new ArrayList<>();
  protected BottomSheetDialog dialog;
  protected SheetModel model;
  protected ListAdapter ad;
  protected TextView title;
  protected MaterialDivider divar;
  public ItemRuner(Context context) {
    this.context = context;
    var view = LayoutInflater.from(context).inflate(R.layout.layout_sheet_main, null);
    title = view.findViewById(R.id.title);
    listview = view.findViewById(R.id.listdata);
    divar = view.findViewById(R.id.diver);
    
    
    dialog = new BottomSheetDialog(context);
    dialog.setContentView(view);
  }

  public void setCancelable(boolean boll) {
    dialog.setCancelable(boll);
  }

  public void setDismiss() {
    dialog.dismiss();
  }

  public void setCallBack(OnItemClickEvent ev) {
    ad = new ListAdapter(list,ev);
     listview.setAdapter(ad);
    listview.setLayoutManager(new LinearLayoutManager(context));
  }

  public void addItem(String name, int icon, boolean bool) {
    list.add(new SheetModel(name, icon, bool));
  }

  public void addItem(String name, int icon) {
    list.add(new SheetModel(name, icon, true));
  }

  public void addItem(String name) {
    list.add(new SheetModel(name, 0, true));
  }

  public void show() {
    dialog.show();
  }

  public void setCustomView(@IdRes int res) {
    dialog.setContentView(res);
  }

  public void setCustomView(View view) {
    dialog.setContentView(view);
  }


  public void setTextColors(int colors) {
    ad.setTextColor(colors);
  }

  public void setColorFilter(int colors) {
    ad.setColorFilter(colors);
  }

  public void setTitle(String str) {
    title.setText(str);
  }

  public void setTitleColor(int color) {
    title.setTextColor(color);
  }

  public void serDivarColor(int color) {
    divar.setDividerColor(color);
  }

  public void serDivarColorFromRes(@IdRes int color) {
    divar.setDividerColorResource(color);
  }

  public void setSheetBackground(int color) {
    dialog.getWindow().getDecorView().setBackgroundColor(color);
  }

  public void setAnimator(boolean bo) {
    ad.setAnimatorItem(bo);
  }
}
