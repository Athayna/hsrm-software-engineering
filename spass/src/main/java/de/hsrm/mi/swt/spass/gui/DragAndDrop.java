package de.hsrm.mi.swt.spass.gui;

import java.util.ArrayList;
import java.util.List;

import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Semester;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;

public class DragAndDrop extends Application {

    //Listen noch nicht mit richtigen Semestern und Modulen gefüllt
    private ListView<Modul> list1 = new ListView();
    private ListView<Modul> list2 = new ListView();

    @Override
    public void start(Stage primaryStage) throws Exception {
        {
            list1.setOnDragDetected(new EventHandler<MouseEvent>()
            {
            @Override
            public void handle(MouseEvent event)
                {
            System.out.println("setOnDragDetected");
            
           Dragboard dragBoard = list1.startDragAndDrop(TransferMode.MOVE);
            
           ClipboardContent content = new ClipboardContent();
            
           content.putString(list1.getSelectionModel().getSelectedItem().getName());
            
           dragBoard.setContent(content);
                }
            });

            list2.setOnDragEntered(new EventHandler<DragEvent>(){
            @Override
            public void handle(DragEvent dragEvent)
                {
            System.out.println("setOnDragEntered");
                }
            });

            list2.setOnDragOver(new EventHandler<DragEvent>(){
                @Override
                public void handle(DragEvent dragEvent)
                    {
                System.out.println("setOnDragOver");
                dragEvent.acceptTransferModes(TransferMode.MOVE);
                    }
                });

                list2.setOnDragDropped(new EventHandler<DragEvent>(){
                @Override
                public void handle(DragEvent dragEvent)
                {
                System.out.println("setOnDragDropped");
                
               String modul = dragEvent.getDragboard().getString();
                
               list2.getItems().addAll(new Modul(modul, 0, false, 0, null, null, null, modul, 0));
                
               list1.getItems().remove(new Modul(modul, 0, false, 0, null, null, null, modul, 0));
                
               dragEvent.setDropCompleted(true);
                }
                });
        
    }
    
}     
        
}
