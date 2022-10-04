package ch2;
class teller_Machine implements Runnable{
 
 static int total=10000;
 int ticket;
 Thread t;

 teller_Machine(String name){
  ticket=0;
  t=new Thread(this,name);
  t.start();
 }

 public void run() {
  while(total > 0) {
   int r = 0;
   r = (int)(Math.random()*4) + 1;
   while((total - r)<0) {
    r = (int)(Math.random()*4) + 1;
   }
   
   ticket += r;
   total -= r;
   System.out.println(t.getName()+"賣了"+ r +"張票");
  }
  
  if(total == 0) {
   try {
    Thread.currentThread().sleep(1000);
   } catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   System.out.println("********"+t.getName()+"總共賣了"+ticket+"張票");
  }  
 }
}

public class hw{
 public static void main(String[] args) {

  teller_Machine tA=new teller_Machine("售票機1號");
  teller_Machine tB=new teller_Machine("售票機2號");
  teller_Machine tC=new teller_Machine("售票機3號");
  teller_Machine tD=new teller_Machine("售票機4號");
 }
}