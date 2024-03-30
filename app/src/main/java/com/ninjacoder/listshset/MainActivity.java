package com.ninjacoder.listshset;

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
    for(int i = 0; i < 400; ++i) {
    	runer.addItem("Hello",R.drawable.ic_launcher_foreground);
    }
    
    runer.setCallBack((pos) ->{
      runer.setDismiss();
    });
    
    runer.show();
    
    
  }
}
