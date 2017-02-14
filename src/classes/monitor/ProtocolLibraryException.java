package monitor;

public class ProtocolLibraryException extends RuntimeException{
	public ProtocolLibraryException(String msg){
		super(msg);
	}

	public ProtocolLibraryException(Throwable e){
		super(e);
	}
}
