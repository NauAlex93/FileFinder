package javafxapplication4;

import java.io.File;
import javafx.collections.ObservableList;

public class FindTask {         //extends Task<Void>{
    final private int    SIZE=200;
    final private ObservableList<String> items1;
    final private String path;
    final private String end;

    
    public FindTask(ObservableList<String> items, String path, String end) {
        this.items1 = items;
        this.path = path;
        this.end = end;
    }

    //only in synk version
    public void doWork() {
        File file=new File(path);
        if (file.isDirectory()) findIn(file);
    }
    
    private void findIn(File fi) {
        File[] files=fi.listFiles((f)->f.getName().endsWith(end) || f.isDirectory());
        
        if (files!=null && items1.size()<SIZE)
            for(File f : files)
                if (f.isDirectory())        findIn(f);  
                else    items1.add(f.getAbsolutePath());
    }                
}
