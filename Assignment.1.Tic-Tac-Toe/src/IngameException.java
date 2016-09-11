/**
 * 
 */

/**
 * @author ZhaoYi
 *
 */
public class IngameException extends RuntimeException {
	private static final long serialVersionUID = 8780124501704029360L;
	String msg;
	public IngameException(){
		super();
	}
	public IngameException(String msg) {  
        super(msg);  
        this.msg = msg;  
    }
	public String toString(){
		return this.msg;
	}
}
