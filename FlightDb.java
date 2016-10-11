//swing Application
//importing Various packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
//extend connect class into FlightDb 
class FlightDb extends connect implements ActionListener
{   
    //Adding Labels for Technology Used Frame
    JLabel jla= new JLabel("TECHNOLOGY USED :-)                                                   ");                      
	JLabel jla1=new JLabel(": :NOTEPAD++                    ///  FOR EDITING                     ");
	JLabel jla2=new JLabel(": :JDK 1.7.0                         ///  FOR COMPILING               ");
	JLabel jla3=new JLabel(": :MS ACCESS 2007          ///  FOR DATABASE               ");
	
	//Adding Labels for About Programmers
	JLabel jla111= new JLabel("ABOUT PROGRAMMERS :-)                                                           ");                      
	JLabel jla11=new JLabel("                                        : :MRUGENDRA D. FALE       ");
	JLabel jla22=new JLabel("                                           : :SIDDHARTH A. GANTHADE ");
	JLabel jla33=new JLabel("                                          : :PIYUSH S. JAISINGKAR      ");
	JLabel jla44=new JLabel("                                       : :SAMIR S. UBHALE            ");
     
	 //Adding Labels for viewList
    JLabel jlab11=new JLabel("Flight Number:       ");
	JLabel jlab22=new JLabel("Booking Number:  ");
	JLabel jlab33=new JLabel("Date:                         ");
	JLabel jlab44=new JLabel("Name Of Passenger:   ");
	JLabel jlab55=new JLabel("Passenger Status:                  ");
	
    //Adding TextFields for viewList
	JTextField jtxt11=new JTextField(15);  
	JTextField jtxt22=new JTextField(15);  
	JTextField jtxt33=new JTextField(15);  
	JTextField jtxt44=new JTextField(13);  
	JTextField jtxt55=new JTextField(10);  
	
	//Adding Frames for About Us,About Programmers,viewList
	JFrame jfrm1; JFrame jfrm2; JFrame jfrm3;
	
	//Adding Labels and ImageIcon for Flight Reservation
   ImageIcon li=new ImageIcon("flt.jpg");
   JLabel jlab9=new JLabel("",li,JLabel.CENTER);
   JLabel jlab1=new JLabel("Flight Number:       ");
   JLabel jlab2=new JLabel("Booking Number:  ");
   JLabel jlab3=new JLabel("Date:                         ");
   JLabel jlab4=new JLabel("Name Of Passenger:   ");
   JLabel jlab5=new JLabel("Passenger Status:                  ");
   JLabel jlab6=new JLabel("");
   JLabel jlab7=new JLabel("Data Inserted Successfully");
   JLabel jlab8=new JLabel("Data Displayed Successfully");
   JLabel jlab10=new JLabel("Data Updated Successfully");
   JLabel jlab12=new JLabel("Data Remove Successfully");
   
    //Adding TextField for Flight Reservation
    JTextField jtxt1=new JTextField(15);  
    JTextField jtxt2=new JTextField(15);  
    JTextField jtxt3=new JTextField(15);  
    JTextField jtxt4=new JTextField(13);  
    JTextField jtxt5=new JTextField(10);  
    
     //Adding Buttons for Flight Reservation	
   JButton jbtn1=new JButton("DATA INSERT");
   JButton jbtn2=new JButton("DATA DISPLAY");
   JButton jbtn3=new JButton("TECHNOLOGY USED");
   JButton jbtn4=new JButton("ABOUT US");
   JButton jbtn7=new JButton("UPDATE");
   JButton jbtn8=new JButton("DELETE");
   
   
   //Adding Frame for Flight Reservation
   JFrame jfrm=new JFrame("FLIGHT RESERVATION");
//Defining Constructor for Class for FlightDb
  FlightDb( )
   {
    //Set size of Frame Flight Reservation
   jfrm.setSize(300,570);
   
   //Adding DateFormat and Date Class for Flight Reservation
   Date date=new Date( );
   DateFormat df;
   df=DateFormat.getDateInstance(DateFormat.SHORT,Locale.UK);
   //Set Layout for Frame Flight Reservation
   jfrm.setLayout(new FlowLayout(FlowLayout.CENTER) );
  
  //Set Date for TextField 3
   jtxt3.setText(""+df.format(date));
   
   //Adding Components to Frame Flight Reservation
   jfrm.add(jlab9);
   jfrm.add(jlab1);  jfrm.add(jtxt1);
   jfrm.add(jlab2);  jfrm.add(jtxt2);
   jfrm.add(jlab3);  jfrm.add(jtxt3);
   jfrm.add(jlab4);  jfrm.add(jtxt4);
   jfrm.add(jlab5);  jfrm.add(jtxt5);
   jfrm.add(jbtn1);  jfrm.add(jlab6);  jfrm.add(jbtn2);
   jfrm.add(jbtn7);  jfrm.add(jlab6);jfrm.add(jbtn8);
   jfrm.add(jbtn3); jfrm.add(jlab6); jfrm.add(jbtn4);
   
   //Adding ActionListener for Buttons in Frame Flight Reservation
   jbtn1.addActionListener(this);
   jbtn2.addActionListener(this);
   jbtn3.addActionListener(this);
   jbtn4.addActionListener(this);
   jbtn7.addActionListener(this);
   jbtn8.addActionListener(this);
   
   //Set Visibility For Frame Flight Reservation
   jfrm.setVisible(true);
   
   //Set Closing Operation for Frame Flight Reservation
   jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   //Calling try and catch method for avoiding possible Errors
	try{ connect con=new connect( );} catch(Exception ex){}
   }
   //Performing Action Events for Buttons
   public void actionPerformed(ActionEvent ae) 
    { String s=ae.getActionCommand();
		if (s.equals("DATA INSERT"))
		{    jfrm.add(jlab7);					
		       try{ 
                     //Inserting Values into Table1 To Database FlightDb			   
		            String inscmd="insert into Table1(Flight_Number,Booking_Number,Dates,Name_Of_Passenger,Passenger_Status) values(?,?,?,?,?)";
					//prepare Connection for Inserting
					pst=con.prepareStatement(inscmd);
					//Set Values into  Flight_Number,Booking_Number,Dates,Name_Of_Passenger,Passenger_Status
					pst.setString(1,jtxt1.getText());
					pst.setString(2,jtxt2.getText());
					pst.setString(3,jtxt3.getText());
					pst.setString(4,jtxt4.getText());
					pst.setString(5,jtxt5.getText());
					//Calling ExecuteUpdate method for Updating values into Table1 
					pst.executeUpdate();
					//Set new Values into TextFields
					jtxt1.setText("");
				    jtxt2.setText("");
					jtxt4.setText("");
					jtxt5.setText("");
					//Calling User Defined Close Function to Close Connection to Database 
                    Close();					
				   }
                catch(Exception ex){}
			jfrm.setVisible(true);
		}
		else if(s.equals("DATA DISPLAY"))
		 { jfrm.add(jlab8);
		   jfrm.setVisible(true);
		    try{    /*Adding new Frame for viewList
                    jfrm1=new JFrame("VIEWLIST");
					Setting Layout for viewList
                    jfrm1.setLayout(new FlowLayout(FlowLayout.CENTER) );
					jfrm1.setSize(300,200);
					jfrm1.setVisible(true);
					jfrm1.add(jlab11);  jfrm1.add(jtxt11);
					jfrm1.add(jlab22);  jfrm1.add(jtxt22);
					jfrm1.add(jlab33);  jfrm1.add(jtxt33);
					jfrm1.add(jlab44);  jfrm1.add(jtxt44);
					jfrm1.add(jlab55);  jfrm1.add(jtxt55);
					*/
					//Calling connect constructor
					connect comm=new connect();
					//Create statement for executing query
                    st=con.createStatement();
					//Executing Query
					rs=st.executeQuery("select * from Table1");
					String st1,st2,st3,st4,st5;
					//Calling Next Function
					System.out.println("\n\n\n\n");
					System.out.println("\t\t\t\t\t\tDATABASE\t\t\t\n");
					System.out.println("");
					System.out.println("FLIGHT_NUMBER   \tBOOKING_NUMBER   \tDATE       \tNAME_OF_PASSENGER\tPASSENGER_STATUS");
					while(rs.next())
					{
					/*jtxt11.setText(rs.getString("Flight_Number"));
					jtxt22.setText(rs.getString("Booking_Number"));
					jtxt33.setText(rs.getString("Dates"));
					jtxt44.setText(rs.getString("Name_Of_Passenger"));
					jtxt55.setText(rs.getString("Passenger_Status"));
					*/
					//Setting Values into TextFields 
					st1=rs.getString("Flight_Number");
					st2=rs.getString("Booking_Number");
					st3=rs.getString("Dates");
					st4=rs.getString("Name_Of_Passenger");
					st5=rs.getString("Passenger_Status");
					System.out.println("\n");
					System.out.println(st1+"\t\t"+st2+"\t\t"+st3+"\t"+st4+"\t\t"+st5+"\t");
					}
					//Calling Close Function
				   Close();
			    }
			catch(Exception ex){}
    }
        else if(s.equals("TECHNOLOGY USED"))
		 {
		    try{   
			        //Adding new Frame for Technology
				    jfrm2=new JFrame("TECHNOLOGY");
					//Setting Layout for Technology
					jfrm2.setLayout(new FlowLayout(FlowLayout.CENTER) );
					jfrm2.setSize(350,150);
					jfrm2.setVisible(true);
					 //Adding Labels or Components to Frame About Technology
					jfrm2.add(jla); 
					jfrm2.add(jla1);
					jfrm2.add(jla2);
					jfrm2.add(jla3);
					//Calling Close Function
					Close();
                 }
				catch(Exception ex){}
		  }
		  else if(s.equals("ABOUT US"))
		  {
		     try{
			     //Adding new Frame for About Programmers
				 jfrm3=new JFrame("ABOUT_PROGRAMMERS");
				 //Setting Layout for About Programmers
				 jfrm3.setLayout(new FlowLayout(FlowLayout.CENTER) );
				 jfrm3.setSize(350,159);
				 jfrm3.setVisible(true);
				 //Adding Labels or Components to Frame About Programmers
				 jfrm3.add(jla111); 
				 jfrm3.add(jla11);
				 jfrm3.add(jla22);
				 jfrm3.add(jla33);
				 jfrm3.add(jla44);
				 //Calling Close Function
				 Close();
				 }
				 catch(Exception ex){}
		  }
		  else if(s.equals("UPDATE"))
		{   jfrm.add(jlab10);
			jfrm.setVisible(true);
			try
			{ connect t=new connect();
			String updcmd="update Table1 set Passenger_Status=?,Dates=? where Name_Of_Passenger=?";
			pst=con.prepareStatement(updcmd);
			pst.setString(1,jtxt5.getText());
			pst.setString(2,jtxt3.getText());
			pst.setString(3,jtxt4.getText());
			pst.executeUpdate();
			jtxt1.setText("");
		    jtxt2.setText("");
			jtxt4.setText("");
			jtxt5.setText("");
			Close();
			}
			catch (Exception ex){}
		}
		else if(s.equals("DELETE"))
		{   jfrm.add(jlab12); 
		    jfrm.setVisible(true);
			try
			{
			pst=con.prepareStatement("delete from Table1 where Name_Of_Passenger=?");
			pst.setString(1,jtxt4.getText());
			pst.executeUpdate();
			jtxt1.setText("");
		    jtxt2.setText("");
			jtxt4.setText("");
			jtxt5.setText("");
			Close();
			}
			catch (Exception ex){}
		}

    }
	//Calling main method
public static void main(String args[ ])
    { 
	 //Calling Runnable Method To run Application
	 SwingUtilities.invokeLater(new Runnable( ) 
	                                                   {  
													      public void run( ) 
														                       { //Creating Object for FlightDb to Calling FlightDb Constructor
																				 new FlightDb();
																				} 
														} 
									) ;
    }
}
