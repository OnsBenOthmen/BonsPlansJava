/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import entities.Offre;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.implementation.OffreService;

/**
 * FXML Controller class
 *
 * @author Ons Ben Othmen
 */
public class BackendProfileOffreController implements Initializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @FXML
    private Text nom;
    @FXML
    private Label deb;
    @FXML
    private Label fin;
    @FXML
    private TextArea des;
    @FXML
    private JFXButton supp;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger Hamburger;

    /**
     * Initializes the controller class.
     */
        public void loadData(int id){
   
          OffreService service=new OffreService();
          Offre e=service.findById(id);
          nom.setText(e.getOffre());
          deb.setText(e.getDate_debut().toString());
          fin.setText(e.getDate_fin().toString());
          des.setText(e.getDescription()); 
          setId(id);
}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 try {
                VBox box = FXMLLoader.load(getClass().getResource("HomePanelBackend.fxml"));
                drawer.setSidePane(box);
                } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
                //Hamburger
                
                HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(Hamburger);
                burgerTask.setRate(-1);
                
                Hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, e ->
                {
                    burgerTask.setRate(burgerTask.getRate() * -1);
                    burgerTask.play();
                    
                    if(drawer.isShown()) drawer.close();
                    else drawer.open();
                });
    }    

    @FXML
    private void delete(ActionEvent event) {
         OffreService service=new OffreService();
                        service.delete(service.findById(id));
                         try {
                        Parent page1 = FXMLLoader.load(getClass().getResource("BackendOffres.fxml"));
                        Scene scene = new Scene(page1);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("Bons Plans - Admin - Les offres courants");
                        stage.show();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                             }        
    }
    
}
