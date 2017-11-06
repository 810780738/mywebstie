package cn.observable.test;

import java.util.Observable;

/**
 * ClassName:ServerManager
 * ClassDescription:被观察者（监听数据变化）
 * @author Administrator
 * @Data 2017年11月6日 上午11:04:57
 */
public class ServerManager extends Observable{
	private int data = 0;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		if (this.data != data) {
			this.data = data;
			setChanged();//设置为被观察的对象
		}
		notifyObservers();//只有当setChanged()方法被调用时才会去触发update
	}
}
