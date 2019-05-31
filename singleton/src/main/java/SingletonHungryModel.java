/**
 * 单例模式 饿汉式
 * @author hc
 */
public class SingletonHungryModel {

	//在定义实例对象时直接初始化
	private static SingletonHungryModel instance = new SingletonHungryModel();

	//私有化构造函数，不允许外部NEW
	private SingletonHungryModel() {

	}

	public static SingletonHungryModel getInstance() {
		return instance;
	}
}
