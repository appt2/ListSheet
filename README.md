# ListSheet

With the help of this library, you can create different functions in a baton sheet without wasting your time.


### How to use?

```java

 ItemRuner runer = new ItemRuner(this);
    	runer.addItem("Hello",R.drawable.ic_launcher_foreground);
      runer.addItem("Hello",R.drawable.ic_launcher_foreground,false);
    
    runer.setCallBack((pos) ->{
      runer.setDismiss();
    });
    runer.setTextColors(Color.CYAN);
    runer.setColorFilter(Color.CYAN);
    runer.serDivarColor(Color.BLUE);
    runer.setTitleColor(Color.CYAN);
    runer.setTitle("Hello");
    runer.setSheetBackground(Color.BLACK);
    runer.show();

```



### Note

I don't really know how to upload the library in mevan or jetpack, if anyone knows how to create a fork, you can also use it as a module.