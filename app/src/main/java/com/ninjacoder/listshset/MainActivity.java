package com.ninjacoder.listshset;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.ninjacoder.listshset.library.adapter.ListAdapter;
import com.ninjacoder.listshset.library.interfaces.OnItemClickEvent;
import com.ninjacoder.listshset.library.widget.ItemRuner;

public class MainActivity extends AppCompatActivity {
  protected ListAdapter ad;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ItemRuner runer = new ItemRuner(this);
    runer.addItem("Hello", "this sub",R.drawable.ic_launcher_foreground,true);
    runer.addItem("Hello",android.R.drawable.checkbox_on_background,false);
    runer.setCallBack(
        new OnItemClickEvent() {

          @Override
          public void onClickItem(int pos) {
            switch(pos){
              case 0 -> runer.setIconFromRes(R.drawable.ic_launcher_background,true); 
              
            }
          }

          @Override
          public void onLongItem(int pos) {}
        });
    runer.setTextColors(Color.CYAN);
    runer.setColorFilter(Color.CYAN);
    runer.serDivarColor(Color.BLUE);
    runer.setTitleColor(Color.CYAN);
    runer.setTitle("Hello");
    runer.setAnimator(true);
    runer.setSheetBackground(Color.BLACK);
    runer.setLayoutChange(false);
     runer.setSubShow(true);
    runer.setShowIcon(true);
    runer.show();
  }
}
