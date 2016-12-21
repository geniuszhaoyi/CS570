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
		Scanner scanner = new Scanner( System.in );
		Network network=new Network(new FileReader());
		while(true){
			System.out.println("if you want to continue enter \"C\"");
			System.out.println("if you want to quit enter \"Q\"");
			System.out.println("if you want to print the routing table of a router, for example router 1 enter \"P 1\"");
			System.out.println("if you want to shut down a router, for example router 1 enter \"S 1\"");
			System.out.println("if you want to start up a router, for example router 1 enter \"T 1\"");
			String input = scanner.nextLine().toUpperCase();
			String []parts=StringSplit.split(input);
			if(parts.length==1)
			{
				if(parts[0].equals("C"))
					network.Continue();
				else if(parts[0].equals("Q"))
					break;
				else{
					System.out.println("please input the right format!");
				}
			}
			else if(parts.length==2)
			{
				try{
					int x=Integer.parseInt(parts[1]);
					if(parts[0].equals("P"))
						network.Print(x);
					else if(parts[0].equals("S"))
						network.ShutDown(x);
					else if(parts[0].equals("T"))
						network.StartUp(x);
					else{
						System.out.println("please input the right format!");
					}
				}catch(NumberFormatException e){
					System.out.println("please input the right format!");
				}
			}
			else
			{
				System.out.println("please input the right format!");
			}
		}
		scanner.close();
	}
}