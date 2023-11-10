/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package midpractice23;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author UseR
 */
public class MidPracticeSceneController implements Initializable {

    @FXML
    private ComboBox<String> selectProductCombo;
    @FXML
    private ComboBox<Integer> quantityCombo;
    @FXML
    private Label unitPriceLabel;
    @FXML
    private Label predefVatLabel;
    @FXML
    private ComboBox<Integer> vatConsiderCombo;
    @FXML
    private TextField maxUnitCostTextField;
    @FXML
    private TextArea totalVatAmountTextArea;
    @FXML
    private TableView<CartItem> tableView;
    @FXML
    private TableColumn<CartItem, String> productCol;
    @FXML
    private TableColumn<CartItem, Integer> unitPriceCol;
    @FXML
    private TableColumn<CartItem, Integer> quantityCol;
    @FXML
    private TableColumn<CartItem, Integer> vatCol;
    @FXML
    private TableColumn<CartItem, Float> vatAmountColumn;
    @FXML
    private TableColumn<CartItem, Float> totalAmountColumn;
    @FXML
    private TextField totAmountLabel;
    @FXML
    private ToggleGroup pMethod;
    @FXML
    private Label paymentMethod;
    @FXML
    private CheckBox cashCheckBox;
    @FXML
    private CheckBox dollarsCheckBox;
    private ObservableList<CartItem> cartList ;
    
    private String sum;
    
    private Float s = 0.0f ;
    @FXML
    private RadioButton cashRB;
    @FXML
    private RadioButton creditRB;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectProductCombo.getItems().setAll("Soap","Milk","Coffee","Tea","Rui Fish","Beef");
        quantityCombo.getItems().setAll(1,2,3,4,5,6,7,8,9,10);
        vatConsiderCombo.getItems().setAll(1,2,3,4,5,6,7,8,9,10);
        productCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        unitPriceCol.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        vatCol.setCellValueFactory(new PropertyValueFactory<>("vatRate"));
        vatAmountColumn.setCellValueFactory(new PropertyValueFactory<>("vatAmount"));
        totalAmountColumn.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        cartList=FXCollections.observableArrayList();
    }    

    @FXML
    private void setUnitVatOnClick(ActionEvent event) {
         if (selectProductCombo.getValue()== "Soap"){
            unitPriceLabel.setText("50");
            predefVatLabel.setText("5");
            
        }
        else if (selectProductCombo.getValue()== "Milk"){
            unitPriceLabel.setText("90");
            predefVatLabel.setText("7");
            
        }
        else if (selectProductCombo.getValue()== "Coffee"){
            unitPriceLabel.setText("70");
            predefVatLabel.setText("3");
            
        }
        else if (selectProductCombo.getValue()== "Tea"){
            unitPriceLabel.setText("40");
            predefVatLabel.setText("5");
            
        }
        
        else if (selectProductCombo.getValue()== "Rui Fish"){
            unitPriceLabel.setText("400");
            predefVatLabel.setText("5");
            
        }
        else if (selectProductCombo.getValue()== "Beef"){
            unitPriceLabel.setText("900");
            predefVatLabel.setText("12");
            
        }
    }

    @FXML
    private void addProductOnCartOnClick(ActionEvent event) {
        
         String productName =  selectProductCombo.getValue();
         int  unitPrice = Integer.parseInt(unitPriceLabel.getText());
         int vatRate = Integer.parseInt(predefVatLabel.getText());
         int quantity = quantityCombo.getValue();
         float dummyVatAmount = unitPrice * vatRate * quantity;
         float vatAmount = dummyVatAmount / 100;
         float TotalAmount = vatAmount + (unitPrice * quantity);
         
         CartItem c1 = new CartItem(productName,unitPrice,vatRate,quantity,vatAmount,TotalAmount);
         cartList.add(c1);
         tableView.setItems(cartList);
        //String sum;
        float i =0;
        for(CartItem x: cartList){
            i+=x.getTotalAmount();
             }sum = Float.toString(i);
             
             
        System.out.println(cartList.toString());
       
    }

    @FXML
    private void checkoutOnClick(ActionEvent event) {
            totAmountLabel.setText(sum);
            if (cashRB.isSelected() && cashCheckBox.isSelected()){
                paymentMethod.setText("Payment Done by Cash "+cashCheckBox.getText());
              
            
            }
            else if (creditRB.isSelected() && dollarsCheckBox.isSelected()){
                paymentMethod.setText("Payment Done by Credit Card And With "+dollarsCheckBox.getText());}
            
    }

    @FXML
    private void showTotalVATonClick(ActionEvent event) {
        System.out.println("VATBUTTON:"+cartList);
        for (CartItem x: cartList){
            if (Integer.parseInt(maxUnitCostTextField.getText())< x.getUnitPrice() && vatConsiderCombo.getValue()== x.getVatRate()){
                s+=x.getVatAmount();
                
            System.out.println(s); }
        }      
        System.out.println(s);   
        
        totalVatAmountTextArea.appendText("The Total Amount VAT Meeting Search Criterion is: "+Float.toString(s));
    }

    @FXML
    private void deletOnClick(ActionEvent event) {
        ObservableList<CartItem> selectedRow = tableView.getSelectionModel().getSelectedItems();
        ObservableList<CartItem> allPeople = tableView.getItems();
        
        for(CartItem x : selectedRow){
            allPeople.remove(x);
        }
    
    }
    
}
