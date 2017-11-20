//package tools;
//
//import bdd.Biere;
//import bdd.BiereCtrl;
//import javax.faces.application.FacesMessage;
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.convert.Converter;
//import javax.faces.convert.ConverterException;
//import javax.faces.convert.FacesConverter;
//
// 
//@FacesConverter("biereConverter")
//public class BiereConverter implements Converter {
// 
//    @Override
//    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
//        // This method is called when HTTP request parameter is to be converted to item value.
//        // You need to convert the student ID back to Student.
//        Integer idBi = Integer.valueOf(value);
//        //Biere biere =  
//        return null;        
//    }
// 
//    @Override
//    public String getAsString(FacesContext fc, UIComponent uic, Object modelValue) {
//        // This method is called when item value is to be converted to HTTP request parameter.
//        // Normal practice is to return an unique identifier here, such as student ID.        
//        if (modelValue == null) {
//            return "";
//        }
//
//        if (modelValue instanceof Biere) {
//            return String.valueOf(((Biere) modelValue).getIdBi());
//        } else {
//            throw new ConverterException(new FacesMessage(modelValue + "is not a valid User entity"));
//        }
//    }   
//}         
//   