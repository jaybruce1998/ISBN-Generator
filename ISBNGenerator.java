import javax.swing.*;
public class ISBNGenerator
{
   static int[] number=new int[13];
   static String typed;
   static int nums;
   public static void checkCode()
   {
      nums=0;
      typed=JOptionPane.showInputDialog("What ISBN number would you like to check?");
      for(int i=1; i<12; i+=2)
         nums+=3*Integer.parseInt(typed.charAt(i)+"");
      for(int i=0; i<12; i+=2)
         nums+=Integer.parseInt(typed.charAt(i)+"");
      nums%=10;
      if(nums>0)
         nums=10-nums;
      if(nums==Integer.parseInt(typed.charAt(12)+""))
         System.out.println(typed+" is a valid ISBN number.");
      else
         System.out.println(typed+" is not a valid ISBN number.");
   }
   public static void generateCodes()
   {
      typed=JOptionPane.showInputDialog("How many numbers would you like to generate?");
      nums=Integer.parseInt(typed);
      for(int n=0; n<nums; n++)
      {
         number[0]=9;
         number[1]=7;
         number[2]=8;
         number[12]=48;
         for(int i=3; i<12; i+=2)
         {
            number[i]=(int)(Math.random()*10);
            number[12]+=number[i]*3;
         }
         for(int i=4; i<12; i+=2)
         {
            number[i]=(int)(Math.random()*10);
            number[12]+=number[i];
         }
         number[12]%=10;
         if(number[12]>0)
            number[12]=10-number[12];
         for(int i=0; i<13; i++)
            System.out.print(number[i]);
         System.out.println();
      }
   }
   public static void main(String[] args)
   {
      typed=JOptionPane.showInputDialog("What would you like to do?\n1) Generate random valid ISBN numbers.\n2) Check the validity of an ISBN number.");
      if(typed.contains("2"))
         checkCode();
      else
         generateCodes();
   }
}