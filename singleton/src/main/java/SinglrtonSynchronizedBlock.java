/**
 * 优化sync方法  代码块校验 会比方法锁定要轻量级一些
 */
public class SinglrtonSynchronizedBlock {
	private static SinglrtonSynchronizedBlock instance = null;

	private SinglrtonSynchronizedBlock() {
	}

	//public synchronized static SinglrtonSynchronizedBlock getInstance() {
	public static SinglrtonSynchronizedBlock getInstance() {
		try {
			synchronized (SinglrtonSynchronizedBlock.class) {
				if (instance != null) {//懒汉式

				} else {
					//创建实例之前可能会有一些准备性的耗时工作 
					Thread.sleep(300);
					instance = new SinglrtonSynchronizedBlock();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return instance;
	}

	//效率有提高 但是会导致线程不安全
	public static SinglrtonSynchronizedBlock getInstance2() {
		try {
			if (instance != null) {//懒汉式

			} else {
				//创建实例之前可能会有一些准备性的耗时工作 
				Thread.sleep(300);
				synchronized (SinglrtonSynchronizedBlock.class) {
					instance = new SinglrtonSynchronizedBlock();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return instance;
	}

}
