package com.ninjacoder.listshset;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.ninjacoder.listshset.library.adapter.ListAdapter;
import com.ninjacoder.listshset.library.interfaces.OnItemClickEvent;
import com.ninjacoder.listshset.library.model.SheetModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  protected ListAdapter ad;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    var list = new ListView(getApplicationContext(), null);
    var parsm =
        new ListView.LayoutParams(
            ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT);
    List<SheetModel> model = new ArrayList<>();
    for(int i = 0; i < 20; ++i) {
    	model.add(new SheetModel("Hello", R.drawable.ic_launcher_foreground, true));
    }
    
    list.setLayoutParams(parsm);
    ad =
        new ListAdapter(
            model,
            new OnItemClickEvent() {

              @Override
              public void onClickItem(View view, int pos, boolean en) {
                Toast.makeText(getApplicationContext(),"this pos -> " + String.valueOf(pos),2).show();
              }
            });
    list.setAdapter(ad);
    var sh = new BottomSheetDialog(this);
    sh.setContentView(list);
    sh.setCancelable(false);
    sh.show();
  }
}
