package System;

public class Item {
	private MySystem mySystem;

	public Item(MySystem mySystem) {
		super();
		this.setMySystem(mySystem);
	}

	public MySystem getMySystem() {
		return mySystem;
	}

	public void setMySystem(MySystem mySystem) {
		this.mySystem = mySystem;
	}

}
