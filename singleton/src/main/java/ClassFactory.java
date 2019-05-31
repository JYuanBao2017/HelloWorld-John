public class ClassFactory {

	public enum MyEnumSingleton {
		//单例工厂
		singletonFactory;

		private MySingleton instance;

		MyEnumSingleton() {//枚举类的构造方法在类加载是被实例化
			instance = new MySingleton();
		}

		public MySingleton getInstance() {
			return instance;
		}
	}

	public static MySingleton getInstance() {
		return MyEnumSingleton.singletonFactory.getInstance();
	}
}

//需要获实现单例的类，比如数据库连接Connection
class MySingleton {

	public MySingleton() {
		ClassFactory.getInstance();
	}

}
