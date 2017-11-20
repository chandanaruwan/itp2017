/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee_manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Diyunuge
 */



public class Employee {
    
    
    
    
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private static String date;
    
    Validation v = new Validation();
    
public Employee(){
       
}
    private String eid;
    private String nic;
    private String fname;
    private String lname;
    private String dob;
    private String teli;
    
    
    private String depart;
    private String national;
    private String position;
    private String gender;
    private String status;
   
    private String address;
    private String email;
    private String basic;
    private String allowance;
    private String join;
    private String medical;
    private String food;     
    
    private String aaad;
    
   // private byte image;
    
    
  
/*
    //1
    public void setEID(String EID) {
        
       if (!v.isempty(EID)){
        this.eid = EID;
    }
       else{
       this.eid = null;      
    }
       
    }
    
     public String getEID() {
         
        return eid;
    }
    
  
   //2 
      public void setFname(String Fname) {
          
          if(!v.isempty(Fname) && v.charactercheck(Fname)){
        this.fname= Fname ;
    }  
      else{
    //   JOptionPane.showMessageDialog(null, "firstname is empty or invalid format", "Error", JOptionPane.ERROR_MESSAGE);        
    this.fname = null;

}
      }
      public String getFname() {
        return fname ;
    }
      
      
      
  //3  
  
      public void setlname(String lname) {
          if(!v.isempty(lname) && v.charactercheck(lname)){
        this.lname= lname;
    }
          
          else{
              this.lname=null;
          }
          
      }
   public String getlname() {
        return lname ;
    }
 
      
      
  //4  
      public void setnic(String nic) {
          if(! v.validateNIC(nic)){
              this.nic= nic;
    }       
          else{
            this.nic=null;
          
          }
      } 
      
       public String getnic() {
        return nic ;
    }
       
       
       
       
   
      
 
   //5 
      public void setteli(String teli) {
        if(v.CheckLength(teli) && (v.phone(teli)) ){
        
                this.teli= teli;
    
        } else
        {
            this.teli=null;
        }
      }
        public String getteli() {
        return teli ;
    }
  
   
    
   
 //6   
      public void setdob(String dob) {
      if(!v.isempty(dob) ){
          this.dob= dob;
      }
      else{
          this.dob=null;
          
      }   
    }  
      
       public String getdob() {
        return dob ;
    }
 
      
 
  //7     
       public String getdepart() {
        return depart ;
    }
    
      public void setdepart(String depart) {
        this.depart= depart;  
      
      }
      
  //8    
     public String getnational() {
        return national ;
    }
    
      public void setnational(String national) {
        this.national= national;   
      
}
 //9
      
     public String getposition() {
        return position ;
    }
    
      public void setposition(String position) {
        this.position= position;   
        
      }
      
      //10
      
       public String getgender() {
        return gender;
    }
    
      public void setgender(String gender) {
        this.gender= gender;   
      }
      
      //11
   
         public String getstatus() {
        return status;
    }
    
      public void setstatus(String status) {
        this.status= status;   
      }
      
   //12 
 
      public void setaddress(String address){
          
       if(!v.isempty(address)){
        this.address= address;   
      }
       else{
           this.address=null;
           
       }
      }      
     public String getaddress() {
        return address;
    }
   
     
     
 
   //13
      public void setemail(String email) {
       if(!v.isempty(email)&& v.EmailValidation(email))
              this.email= email; 
       
       else{
           
           this.email=null;
       
       }
      }
         public String getemail() {
        return email;
    }
         
         
 
      
 //14
      public void setbasic(String basic){
       if(!v.isempty(basic)){
          
          this.basic= basic;   
      }
       else{
          this.basic=null;
           
       }  }
      public String getbasic() {
        return basic;
    }
    
      
    //15  
      
      public void setallowance(String allowance) {
        if(!v.isempty(allowance)){
            
            this.allowance= allowance;   
        }
        else{
            
           this.allowance=null;
      
                 }}
        
         public String getallowance() {
        return allowance;
    }
   
      
   //16
      public void setjoin(String join) {
       if(!v.isempty(join)){
           this.join= join;
       }
       
       else{
           
          this.join=null;
       }
      }
      
          public String getjoin() {
        return join;
    }
 
  
  //***************************************************    
     public boolean chekDup(String check) {

        boolean ans = false;
        String query = "SELECT NIC FROM employee WHERE NIC='" + check+ "'";
        con = db.Database.connect();
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            if (rs.next()) {

                String getnic = rs.getString("NIC");
                if (getnic.equals(check)) {

                    ans = true;
                } else {
                    ans = false;
                }
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

        return ans;
    }  
     

   //*************************************************8   
  public boolean  addemployee() {
               
       boolean ans=false;
       
        System.out.println(getEID());
        System.out.println(getFname());
        System.out.println(getlname());
        System.out.println(getteli());
        System.out.println(getemail());
        System.out.println(getnic());
        System.out.println(getallowance());
        System.out.println(getbasic());
        System.out.println(getaddress());
        
     //   System.err.println(getIholderName())
        
        
        System.out.println(getjoin());
        System.out.println(getdob());
        
        System.out.println(getstatus());
        System.out.println(getgender());
        System.out.println(getnational());
        System.out.println(getdepart());
        System.out.println(getposition());
        
       
     
      if (getEID() != null &&getFname() !=null && getlname() != null && getnic() != null && getaddress() != null && getdob() != null && getemail() != null && getposition() != null && getallowance() != null && getbasic() != null && getgender() != null && getdepart() != null && getteli() != null) {

        if (chekDup(getnic())) {

          JOptionPane.showMessageDialog(null, "Employee Already Registerd !!!");
         
         //   }
      }
          else  {
        
                 
     Connection con =db.Database.connect();
                 
     String insert_Staff = "INSERT INTO employee(Empid,FirstName,LastName,NIC,Dob,Sex,Nationality,Marital,position,joined,teliphone,email,address,bsalary,alowance,department) VALUES ('"+getEID()+ "', '" + getFname() + "','" + getlname() + "','" + getnic() + "','" + getdob() + "','" + getgender() + "','" + getnational() + "','" + getstatus() + "','" + getposition() + "','" + getjoin() + "','" + teli + "','" + getemail() + "','" + getaddress() + "','" + getbasic() + "','" + getallowance() + "','" + getdepart()+ "')";

              try{
                   PreparedStatement pst = con.prepareStatement(insert_Staff);
                        pst.execute();
                        ans = true;
                       
                    }
               catch(SQLException ex){
                            
    
                    JOptionPane.showMessageDialog(null,"");
                    System.out.println(ex);
                    }
      }
      
  
      }else{      

            ans=false;

      }
            return ans;

  } 
}


*/
         
  
  
      
      
   public void setEID(String EID) {
        
        this.eid = EID;
 
    }
    
     public String getEID() {
         
        return eid;
    }
    

     
     
   //2 
      public void setFname(String Fname) {
     
        this.fname= Fname ;
      }

      
      public String getFname() {
        return fname ;
    }
      
  
      
      
  //3  
  
      public void setlname(String lname) {
          
        this.lname= lname;
    }
    
   public String getlname() {
        return lname ;
    }
 
   
   
      
  //4  
      public void setnic(String nic) {
        
              this.nic= nic;
 
          }
      
       public String getnic() {
        return nic ;
    }
       
    
 
   //5  setteli(String teli)
      public void setteli(String teli) {
       
                this.teli= teli;
   
        }
      
        public String getteli() {
        return teli ;
    }
  
  
 //6   
      public void setdob(String dob) {
      
          this.dob= dob;
      }
   
       public String getdob() {
        return dob ;
    }
 
      
 
  //7     
       public String getdepart() {
        return depart ;
    }
    
      public void setdepart(String depart) {
        this.depart= depart;  
      
      }
      
  //8    
     public String getnational() {
        return national ;
    }
    
      public void setnational(String national) {
        this.national= national;   
      
}
 //9
      
     public String getposition() {
        return position ;
    }
    
      public void setposition(String position) {
        this.position= position;   
        
      }
      
      //10
      
       public String getgender() {
        return gender;
    }
    
      public void setgender(String gender) {
        this.gender= gender;   
      }
      
      //11
   
         public String getstatus() {
        return status;
    }
    
      public void setstatus(String status) {
        this.status= status;   
      }
      
   //12 
 
      public void setaddress(String address){
          
      
        this.address= address;   
     
      }      
     public String getaddress() {
        return address;
    }
   
     
     
 
   //13
      public void setemail(String email) {
      
              this.email= email; 
    
      }
         public String getemail() {
        return email;
    }
         
         
 
      
 //14
      public void setbasic(String basic){
     
          
          this.basic= basic;   
   
       }
      public String getbasic() {
        return basic;
    }
    
      
    //15  
      
      public void setallowance(String allowance) {
       
            this.allowance= allowance;   
      }
          
          
        
         public String getallowance() {
        return allowance;
    }
   
      
   //16
      public void setjoin(String join) {
     
           this.join= join;
       }
       
      
      
      
          public String getjoin() {
        return join;
    }
       
          
      //17    
            public void setmedical(String medical){
     
          
          this.medical= medical;   
   
       }
      public String getmedical() {
        return medical;
    }
    
      
    //18  
      
      public void setfood(String food) {
       
            this.food= food;   
      }
          
          
        
         public String getfood() {
        return food;
    }
      
 
          
      public boolean chekDup(String checkNIC) {

        boolean ans = false;
        String query = "SELECT NIC FROM employee WHERE NIC='" + checkNIC + "'";
        con = db.Database.connect();
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            if (rs.next()) {

                String getnic = rs.getString("NIC");
                if (getnic.equals(checkNIC)) {

                    ans = true;
                } else {
                    ans = false;
                }
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

        return ans;
    }
      
      
   //Employee ID  
      
       public boolean checkID(String idvalid) {

        boolean ans = false;
        String query = "SELECT Empid FROM employee WHERE Empid='" + idvalid + "'";
        con = db.Database.connect();
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            if (rs.next()) {

                String getEID = rs.getString("Empid");
                if (getEID.equals(idvalid)) {

                    ans = true;
                } else {
                    ans = false;
                }
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

        return ans;
    }
      
      
      
      
 
      
  
 
  public void addemployee() {
    home h =new home();
   if (checkID(getEID())){
         
         
       JOptionPane.showMessageDialog(null, "This Employee ID Is Used!!!");
             
   }
       
        else if (chekDup(getnic())) {

          JOptionPane.showMessageDialog(null, "This NIC IS Already Registerd !!!");
              
              }
           else{ 
               
     Connection conn =db.Database.connect();
                 
     String insert_Staff = "INSERT INTO employee(Empid,FirstName,LastName,NIC,Dob,Sex,Nationality,Marital,position,joined,teliphone,email,address,bsalary,alowance,department,FoodAllowance,MedicalAllowance) VALUES ('"+ eid + "', '" + fname + "','" + lname + "','" + nic + "','" + dob + "','" + gender + "','" + national + "','" + status + "','" + position + "','" + join + "','" + teli + "','" + email + "','" + address + "','" + basic + "','" + allowance + "','" + depart+ "','" + food + "','" + medical+ "')";


              try{
                   PreparedStatement pst = conn.prepareStatement(insert_Staff);
                        pst.execute();
                        
                    JOptionPane.showMessageDialog(null, "Employee Add Succefully");  
                 
                   h.tableload1();
                   
                      // ans = true;
                       
                    }
               catch(SQLException ex){
                            
    
                    JOptionPane.showMessageDialog(null,"");
                    System.out.println(ex);
       
               }
  }
}
}
/*

 public boolean  addemployee() {
               
       boolean ans=false;
       
       
        System.out.println(getFname());
        System.out.println(getlname());
        System.out.println(getteli());
        System.out.println(getemail());
        System.out.println(getnic());
        System.out.println(getaddress());
        System.out.println(getbasic());
     //   System.err.println(getIholderName())
       
     
      if (getEID() != null &&getFname() !=null && getlname() != null && getnic() != null && getaddress() != null && getdob() != null && getemail() != null && getposition() != null && getallowance() != null && getbasic() != null && getgender() != null && getdepart() != null && getteli() != null) {

        if (chekDup(getnic())) {

          JOptionPane.showMessageDialog(null, "Employee Already Registerd !!!");
         
         //   }
      }
          else  {
        
                 
     Connection con =db.Database.connect();
                 
     String insert_Staff = "INSERT INTO employee(Empid,FirstName,LastName,NIC,Dob,Sex,Nationality,Marital,position,joined,teliphone,email,address,bsalary,alowance,department) VALUES ('"+getEid + "', '" + fname + "','" + lname + "','" + nic + "','" + dob + "','" + gender + "','" + national + "','" + status + "','" + position + "','" + join + "','" + teli + "','" + email + "','" + address + "','" + basic + "','" + allowance + "','" + depart+ "')";

              try{
                   PreparedStatement pst = con.prepareStatement(insert_Staff);
                        pst.execute();
                        ans = true;
                       
                    }
               catch(SQLException ex){
                            
    
                    JOptionPane.showMessageDialog(null,"");
                    System.out.println(ex);
                    }
      }
      
  
      }else{      

            ans=false;

      }
            return ans;

  } 
}

  
*/
        

    //  else{      

      //       ans=false;


         //    return ans;

      
  
          
      
      
      
      
      
      
      



