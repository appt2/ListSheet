package com.ninjacoder.listshset.library.model;

import androidx.annotation.NonNull;

public class SheetModel {

  @NonNull private String name;
  @NonNull private int icon;
  @NonNull private boolean isItem;
  
  
  public SheetModel(){}

  public SheetModel(String name, int icon, boolean isItem) {
    this.name = name;
    this.icon = icon;
    this.isItem = isItem;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getIcon() {
    return this.icon;
  }

  public void setIcon(int icon) {
    this.icon = icon;
  }

  public boolean getIsItem() {
    return this.isItem;
  }

  public void setIsItem(boolean isItem) {
    this.isItem = isItem;
  }
}
