/**
 * 线程安全的单例模式
 * 但是这种锁实现单例模式 运行效率很低
 */
public class SinglrtonSynchronizedMethod {
	private static SinglrtonSynchronizedMethod instance = null;

	private SinglrtonSynchronizedMethod(){}

	public synchronized static SinglrtonSynchronizedMethod getInstance() {
		try {
			if(instance != null){//懒汉式

			}else{
				//创建实例之前可能会有一些准备性的耗时工作
				Thread.sleep(300);
				instance = new SinglrtonSynchronizedMethod();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return instance;
	}

}
