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
		network.Continue();
		network.ShutDown(0);
		network.StartUp(0);
		network.Print(0);
	}

}
