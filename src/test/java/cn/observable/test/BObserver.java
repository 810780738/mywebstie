package cn.observable.test;

import java.util.Observable;
import java.util.Observer;

public class BObserver implements Observer {

	
	
	public BObserver(ServerManager sm) {
		super();
		sm.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("观察者2监听到的数据:"+((ServerManager)o).getData());
	}

}
