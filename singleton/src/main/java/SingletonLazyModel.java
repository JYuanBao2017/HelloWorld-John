/**
 * 懒汉式单例模式
 * 该模式在多线程下会破坏单例
 * @author hc
 */
public class SingletonLazyModel {
	private static SingletonLazyModel instance=null;
	private SingletonLazyModel(){

	}
	public static SingletonLazyModel getInstance() throws InterruptedException {
		if (instance==null){
			//模拟数据加载比较多的时候 这样在多线程的时候会出问题
			Thread.sleep(100);
			instance=new SingletonLazyModel();
		}
		return instance;
	}


}
