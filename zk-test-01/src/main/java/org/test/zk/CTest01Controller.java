package org.test.zk;


import org.test.zk.dao.CPerson;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.ItemRenderer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Selectbox;
import org.zkoss.zul.Window;


public class CTest01Controller extends SelectorComposer<Component> implements ItemRenderer<CPerson> {

       private static final long serialVersionUID = -258902408111073465L;
    
       @Wire
       Button buttonTest01;
       
       @Wire("#buttonMiSuperBoton")
       Button buttonTest02;
       
       @Wire
       Selectbox selectBox01;
       
       @Wire
       Selectbox selectBox02;
       
       @Wire
       Window windowsTest01;
       
       protected ListModelList<String> dataModel = new ListModelList<String>();
       protected ListModelList<CPerson> dataModelPerson = new ListModelList<CPerson>();
       
       @Listen("onClick =#buttonTest01")
       public void onClickbuttonTest01(Event event){
           windowsTest01.setTitle( "listo este evento" );
           buttonTest02.setLabel( "Presionado el Boton" );
           dataModel.add( "1" );
           dataModel.add( "2" );
           dataModel.add( "3" );
           dataModel.add( "4" );
           
           dataModelPerson.add( new CPerson("13668163","jean","newman") );
           dataModelPerson.add( new CPerson("13668164","este","este") );
           dataModelPerson.add( new CPerson("13668165","el otro","aquel") );
           selectBox02.setModel( dataModelPerson );
           //dataModelPerson.addToSelection( "1" );
           selectBox02.setItemRenderer( this );
           selectBox01.setModel( dataModel );
           dataModel.addToSelection( "1" );
           selectBox01.setSelectedIndex( 0 );
       }
       
       @Listen("onSelect = #selectBox02")
       public void onSelectbox02Test(Event event){
           
           if(selectBox02.getSelectedIndex()>=0){
          
               CPerson personSelected = dataModelPerson.get( selectBox02.getSelectedIndex() );
               windowsTest01.setTitle( personSelected.getId() );
         
           }
       }
       
       @Listen("onSelect = #selectBox01")
       public void onSelectbox01Test(Event event){
           
           if(selectBox01.getSelectedIndex()>=0){
           windowsTest01.setTitle( dataModel.get( selectBox01.getSelectedIndex() ) );
         
           }
       }
       
       @Listen("onClick =#buttonMiSuperBoton")
       public void onClickbuttonTest02(Event event){
           windowsTest01.setTitle( "el evento 2" );
           buttonTest02.setLabel( "Presionado el Boton 2" );
       }
       
       @Listen("onClick =#buttonTest03")
       public void onClickbuttonTest03(Event event){
           windowsTest01.doModal();
       }

    @Override
    public String render( Component arg0, CPerson arg1, int arg2 ) throws Exception {
        
        // TODO Auto-generated method stub
        return arg1.getFirstName()+ " " +arg1.getLastName();
    }
       
}
