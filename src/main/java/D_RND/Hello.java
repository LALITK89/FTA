package D_RND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Hello 
{

	public static void world()
	{
		
//Store value in a Array
     int[] arr = new int[5];
     arr[0] = 1;
     arr[1] = 2;
     arr[2] = 3;
     arr[3] = 4;
     arr[4] = 122;
     for (int i=0; i<arr.length; i++)
     {
    	System.out.println(arr[i]); 
     }
     
     
      //Second way to store the value in a Array
     int[] arr1 = {1,2,3,122,4};
     for (int i=0; i<arr1.length; i++)
     {
    	System.out.println(arr1[i]);
     
	}
     
     
     //Store staing in a Array
     String[] name = new String[3];
     name[0]= "Lalit";
     name[1]= "Kumar";
     name[2]= "Chauhan";
     for(int i = 0; i<name.length; i++)
     {
    	 System.out.println(name[i]);
     }
     
     
     //Find the value which can be divide by 2
     int[] value = new int[10];
     value[0]=1;
     value[1]=2;
     value[2]=3;
     value[3]=4;
     value[4]=5;
     value[5]=6;
     value[6]=7;
     value[7]=8;
     value[8]=9;
     value[9]=10;
     
     for(int i=0; i<value.length; i++)
     {
    	 if(value[i]%2==0)
    	 {
    		 System.out.println(value[i]);
    	 }
    	 else
    	 {
    		 System.out.println(value[i]+" is not divide by 2.");
    	 }
     }
     
  //Arraylist fuctionality
   ArrayList<String> a =  new ArrayList<String>();
   a.add("Ritu");  
   a.add("Kumar"); 
   a.add("chauhan"); 
    {
	   for(int i = 0;i<a.size(); i++)
	   {
		   System.out.println(a.contains("Ritu"));
	   }
    }
   
   //Convert array to arraylist
//   String[] val = {"Lalit", "Ritu", "Kunj"};
//   List<String> newarray =  Arrays.asList(val);
//   newarray.contains("Lalit");
//   newarray.add("Chauhan");
  
   
 
     
	//String literal- will not create S1 because already s having save value.
	String s = "Lalit kumar Invenio";
	String s1 = "Lalit kumar Invenio";
	
	//it will store all value in both variable
	String s2 = new String("Lalit kumar Invenio");
	String s3 = new String("Lalit kumar Invenio");
	//Split the space
	String s6 = "Lalit kumar Invenio";
	String[] newstring = s6.split(" ");
	System.out.println(newstring[0]);
	System.out.println(newstring[1]);
	System.out.println(newstring[2]);
	
	//Remove the space before or after the string
	System.out.println(newstring[1].trim());
	// convert string in charateres
	String s7 = "Lalit kumar Invenio";
	for(int i=0; i<s7.length();i++)
	{
		System.out.println(s7.charAt(i));
	}
	
	// convert string in reverse charateres
		String s8 = "Lalit kumar Invenio";
		for(int i=s8.length()-1; i>=0;i--)
		{
			System.out.println(s8.charAt(i));
		}
}
 public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		world();
	}

}
