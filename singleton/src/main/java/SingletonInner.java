import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 使用静态内部类实现单例
 * 同时 如果涉及到序列化 单纯的实现Serializable 接口并不能保证单例 需要 readResole()
 * @author hc
 */
public class SingletonInner implements Serializable{
	private static final long serialVersionUID=1L;
	//内部类
	private static class SingletonInnerHandler{
		private static SingletonInner instance = new SingletonInner();
	}

	private SingletonInner(){}

	public static SingletonInner getInstance() {
		return SingletonInnerHandler.instance;
	}
	//该方法在反序列化时会被调用，该方法不是接口定义的方法，有点儿约定俗成的感觉
	protected Object readResolve() throws ObjectStreamException {
		System.out.println("调用了readResolve方法！");
		return SingletonInnerHandler.instance;
	}


}
