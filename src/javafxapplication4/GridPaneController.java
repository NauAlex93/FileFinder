package javafxapplication4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class GridPaneController implements Initializable {
    @FXML private TextField pathId;
    @FXML private TextField endId;
    @FXML private ProgressBar barId;
    @FXML private ListView<String> listId;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JavaFXApplication4.items.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change obj) {
                listId.setItems(obj.getList());
            }
        });
    }    
    @FXML
    protected void btnFindClick(ActionEvent event) {
        String path=pathId.getText();
        String end =endId.getText();
        
        JavaFXApplication4.items.clear();
        barId.setProgress(-1);
        
        new FindTask(JavaFXApplication4.items, path, end).doWork();
		
		//run asynk Task in concurrent version
		
		
        barId.setProgress(1);
    }
    @FXML
    protected void btnCancelClick(ActionEvent event) {
        System.out.println("Try to Cancel!");
    }
}
