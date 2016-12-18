import java.util.Scanner;

/**
 * @author TanJinyu
 *
 */
public class Main {

	/**
	 * This is the real main function. Others are only for testing. 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Network network=new Network(new FileReader());
		while(true){
			System.out.println("if you want to continue enter \"C\"");
		     System.out.println("if you want to quit enter \"Q\"");
			System.out.println("if you want to print the routing table of a router, for example router 1 enter \"P 1\"");
			System.out.println("if you want to shut down a router, for example router 1 enter \"S 1\"");
			System.out.println("if you want to start up a router, for example router 1 enter \"T 1\"");
			   Scanner scanner = new Scanner( System.in );
			   String input = scanner.nextLine();
			   if(input.length()==1)
			   {
			   if(input.equals("C"))
			   network.Continue();
			   else if(input.equals("Q"))
			   break;
			   else{
				   System.out.println("please input the right format!");
			   }
			   }
			   else if(input.length()>=3)
			   {
			   String[] parts = input.split(" ");
			   String part1 = parts[0]; 
			   String part2 = parts[1];
			   if(part1.equals("P"))
			   network.Print(Integer.parseInt(part2));
			   else if(part1.equals("S"))
			   network.ShutDown(Integer.parseInt(part2));
			   else if(part1.equals("T"))
			   network.StartUp(Integer.parseInt(part2));
			   else{
				   System.out.println("please input the right format!");
			   }
			   }
			   else
			   {
				   System.out.println("please input the right format!");
				   
			   }
			   
			   
			   
			   
			   
			   
			   
			   
		}
	}

}
