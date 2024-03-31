package com.ninjacoder.listshset;

import android.graphics.Color;
import android.view.View;
import android.widget.Toast;
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
    runer.addItem("Hello", R.drawable.ic_launcher_foreground, true);
    runer.addItem("Hello", R.drawable.ic_launcher_foreground, false);
    runer.addItem("Hello", R.drawable.ic_launcher_foreground, false);
    runer.addItem("Hello", R.drawable.ic_launcher_foreground, false);
    runer.addItem("Hello", R.drawable.ic_launcher_foreground, false);
    runer.addItem("Hello", R.drawable.ic_launcher_foreground, false);

    runer.setCallBack(
        new OnItemClickEvent() {

          @Override
          public void onClickItem(int pos) {}

          @Override
          public void onLongItem(int pos) {
            runer.removed(pos);
            runer.DataRomved(pos);
          }
        });
    runer.setTextColors(Color.CYAN);
    runer.setColorFilter(Color.CYAN);
    runer.serDivarColor(Color.BLUE);
    runer.setTitleColor(Color.CYAN);
    runer.setTitle("Hello");
    runer.setAnimator(true);
    runer.setSheetBackground(Color.BLACK);
    runer.show();
  }
}
