
package employee_manage;

//import javax.swing.JOptionPane;
//import employee_manage.home;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Diyunuge
 */
public class Validation {
    
    
       String Date1;

    
 
    public static boolean Validname(String text) {

        if (text.matches("^[a-zA-Z\\s]*$")) {
            return true;
        } else {

            return false;
     
        }
    }
     /*   
     public static boolean isempty(String fieldContent){
        
        if((fieldContent==null)||(fieldContent.isEmpty()))
            return true;
        else 
            return false;
    }
   */
   public static boolean isLettersOnly(String str) {
    String expression = "^[a-zA-Z.\\s]+"; 
    return str.matches(expression);        
    }
   
   
   
   
   
     public boolean isempty(String field){
    
        if (field.length() == 0) {
            
            return true;
        }
        else{
            
            return false;
        }
    }
    
     
     
     
  //^^^^^^^^^^^validate nic  length 10 & final character V or v^^^^^^^^^^^^^^^^^
     
     
      public boolean validID(String ID){

   			 if(ID.length()==10 && ID.endsWith("V")|| ID.endsWith("v"))
       				 return true;
 			   else
      				 return false;
                         }
     
      
      
         public boolean validTNO(String tno)
{
    		if(tno.length()==10 && tno.startsWith("0"))
{
    			for(int i=0;i<10;i++)
{
    				char c=tno.charAt(i);
   				 if(!Character.isDigit(c))
    					return false;
    			}
   				 return true;
   		 }
else
        			return false;        
    }

     
     

     
 
      
    public boolean CheckNicLetters(String nicpart) {

        boolean ans = false;

        String subNic = nicpart.substring(0, 9);
        //System.out.println(subNic);
        int count = 0;
        if (subNic.length() == 9) {

            while (count < 9) {
                if (Character.isLetter(subNic.charAt(count))) {
                    ans = true;
                    break;
                }

                count++;
            }

        }

        return ans;
    }
    
    
    
    public boolean CheckLength(String field){
    
       if(field.length() > 4){
       
           return true;
       }
       
       else{
           
           return false;
       }
    }
    
    public boolean CheckNumber(String field) {

        int length = field.length();
        int l = 0;
        boolean ans = true;
        while (l < length) {

            if (Character.isLetter(field.charAt(l))) {

                ans = false;
                break;

            }
            
            l++;

        }
   return ans;
    }
    
   //************************************************************************************************************************ 
    
    public boolean charactercheck(String field){
    
        if ((field.matches("[a-zA-Z]*"))) {
            
            return true;
        }
        
        else{
            
            return false;
        }
    }
/*
    public boolean CheckNumber(String field){
    
        if (field.matches("[0-9]*")) {
            
            return true;
        }
        
        else{
            
            return false;
        }
      
    }

*/
      public boolean phone(String field) {

        if (field.length() == 10) {

            return true;
        } else {

            return false;
        }

    }
 /*   
 public boolean CheckNicLetters(String nicpart) {

        boolean ans = false;

        String subNic = nicpart.substring(0, 9);
        //System.out.println(subNic);
        int count = 0;
        if (subNic.length() == 9) {

            while (count < 9) {
                if (Character.isLetter(subNic.charAt(count))) {
                    ans = true;
                    break;
                }

                count++;
            }

        }

        return ans;
    }
    */ 
    //************************************************************************************************************************
     public boolean EmailValidation(String email){
       boolean state;
      Pattern p = Pattern.compile("^[A-Za-z0-9-]+(\\-[A-Za-z0-9])*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9])");
        Matcher m = p.matcher(email);

        if (m.find())
        {
           state = true;
        }else{
           state = false; 
        }

        return state;
    }
     
     
     
     //************************************************************************
     
      public void showDate() {
        Date d = new Date();
        SimpleDateFormat show = new SimpleDateFormat("yyyy-MM-dd");
        Date1 = show.format(d);
    }
     
    //*************************************************************************
     //Check if Customer Birthday is Future or Current Date
    public boolean checkdob(String Birthday) {

        boolean ans = false;
        showDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date currentDate = sdf.parse(Date1);
            Date chooseDate = sdf.parse(Birthday);

            if (chooseDate.equals(currentDate) || chooseDate.after(currentDate)) {

                return true;
            } else {

                return false;
            }

        } catch (ParseException e) {

            JOptionPane.showMessageDialog(null, e);
        }
        
        return ans;
    }

     
    
}

   
   
   
   
   
   
   
   
   
   
   
   
    
    
    

 
    
    
    
    

