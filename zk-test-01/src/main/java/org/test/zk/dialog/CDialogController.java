package org.test.zk.dialog;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Selectbox;
import org.zkoss.zul.Textbox;


public class CDialogController extends SelectorComposer<Component> {

     private static final long serialVersionUID = -8977563222707532143L;
     protected ListModelList<String> dataModel = new ListModelList<String>();
     
     @Wire
     Label labelId;
     
     @Wire
     Label labelNombre;
     
     @Wire
     Label labelApellido;
     
     @Wire
     Label labelGenero;
     
     @Wire
     Label labelFechaNac;
     
     @Wire
     Label labelComentario;
     
     @Wire
     Textbox textId;
     
     @Wire
     Textbox textNombre;
     
     @Wire
     Textbox textApellido;
     
     @Wire
     Textbox textComentario;
     
     @Wire
     Selectbox selectBoxGenero;
     
     @Wire
     Datebox textFechaNac;
     
     public void doAfterCompose(Component comp) {
         
        try {
            super.doAfterCompose(comp);
            textFechaNac.setFormat( "dd/MM/yyyy" );
            dataModel.add( "Femenino" );
            dataModel.add( "Masculino" );
            selectBoxGenero.setModel( dataModel );
            
        }
        catch ( Exception e ) {
            
            e.printStackTrace();
        } 
         
      }
      
     @Listen("onClick=#buttonAceptar")
     public void onClickButtonAceptar(Event event){
         
         Messagebox.show("id: "+ textId.getValue() +" " + textNombre.getValue() +" "+textApellido.getValue(), "Aceptar", Messagebox.OK, Messagebox.INFORMATION);
         // System.out.println( "hola aceptar" );
     }
    
     @Listen("onClick=#buttonCancelar")
     public void onClickButtonCancelar(Event event){
         
         Messagebox.show("Cancelar", "Cancelar", Messagebox.OK, Messagebox.INFORMATION);
         
         //System.out.println( "hola cancelar" );
     }
}
