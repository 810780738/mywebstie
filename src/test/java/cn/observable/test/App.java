package cn.observable.test;

public class App {
	public static void main(String[] args) {
		ServerManager sm = new ServerManager();
		AObserver aObserver = new AObserver(sm);
		BObserver bObserver = new BObserver(sm);
		sm.setData(5);
		sm.deleteObserver(bObserver);
		sm.setData(15);
	}
}
