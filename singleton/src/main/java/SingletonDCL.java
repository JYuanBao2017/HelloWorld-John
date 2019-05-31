/**
 * double check locking 双重检验
 * @author hc
 */
public class SingletonDCL {
	//使用volatile关键字保其可见性
	volatile private static SingletonDCL instance = null;

	private SingletonDCL(){}

	public static SingletonDCL getInstance() {
		try {
			if(instance != null){//懒汉式 

			}else{
				//创建实例之前可能会有一些准备性的耗时工作 
				Thread.sleep(300);
				synchronized (SingletonDCL.class) {
					if(instance == null){//二次检查
						instance = new SingletonDCL();
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return instance;
	}
	
}
