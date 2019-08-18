package chapter7;

public class Question2 {

	public static void main(String[] args) {
		CallCenter cc = new CallCenter();
		cc.dispatchCall();
		cc.dispatchCall();
		cc.dispatchCall();
		cc.dispatchCall();
		
		cc.res.finishCall();
		cc.dir.finishCall();
		cc.dispatchCall();
		cc.dispatchCall();

	}

}

class CallCenter {
	respondent res = new respondent();
	manager man = new manager();
	director dir = new director();
	
	public void dispatchCall() {
		if (res.getAvailability()) {
			
			res.assignCall();
		} else {
			if (man.getAvailability()) {
				
				man.assignCall();
			} else {
				if (dir.getAvailability()) {
					dir.assignCall();
				} else {
					System.out.println("All workers are not available now");
				}
			}
		}
	}
	
}

abstract class worker {
	boolean isAvailable = true;
	
	public boolean getAvailability() {
		return isAvailable;
	}
	
	public void assignCall() {
		this.isAvailable = false;
	}
	
	public void finishCall() {
		this.isAvailable = true;
	}
	
}

class respondent extends worker{
	
	@Override
	public void assignCall() {
		isAvailable = false;
		System.out.println("The call is assigned to the respondent");
	}
	
	@Override
	public void finishCall() {
		this.isAvailable = true;
		System.out.println("The respondent's call is finished");
	}
	
}

class manager extends worker{
	@Override
	public void assignCall() {
		isAvailable = false;
		System.out.println("The call is assigned to the manager");
	}
	
	@Override
	public void finishCall() {
		this.isAvailable = true;
		System.out.println("The manager's call is finished");
	}
}

class director extends worker{
	@Override
	public void assignCall() {
		isAvailable = false;
		System.out.println("The call is assigned to the director");
	}
	
	@Override
	public void finishCall() {
		this.isAvailable = true;
		System.out.println("The director's call is finished");
	}
	
}