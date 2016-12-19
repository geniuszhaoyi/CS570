/**
 * @author ZhaoYi
 *
 */
public class Network {
	Graph g;
	Router[] routers;
	
	public Network(FileReader fr){
		routers=fr.read_infile_dat();
	}
	
	public void Continue(){
		// TODO Auto-generated method stub
		System.out.println(">>continue");
	}
	public void Print(int routerID){
		// TODO Auto-generated method stub
		System.out.println(">>print "+routerID);
		
	}
	public void ShutDown(int routerID){
		// TODO Auto-generated method stub
		System.out.println(">>shutdown "+routerID);
		
	}
	public void StartUp(int routerID){
		// TODO Auto-generated method stub
		System.out.println(">>startup "+routerID);
		
	}
}
