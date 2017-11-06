package cn.observable.test;

import java.util.Observable;
import java.util.Observer;

public class AObserver implements Observer {
	

	public AObserver(ServerManager sm) {
		super();
		sm.addObserver(this);//当前对象注册为观察者
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("观察者1监听到的数据:"+((ServerManager)o).getData());
	}

}
