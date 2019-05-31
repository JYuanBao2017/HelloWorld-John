/**
 * 静态代码块实现单例 静态代码块的代码在使用类的时候就已经执行了
 * @author hc
 */
public class SinglrtonStatic {
	private static SinglrtonStatic instance = null;

	private SinglrtonStatic(){}

	static{
		instance = new SinglrtonStatic();
	}

	public static SinglrtonStatic getInstance() {
		return instance;
	}

}
