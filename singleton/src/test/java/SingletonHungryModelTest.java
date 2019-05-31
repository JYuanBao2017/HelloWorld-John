import org.junit.Test;

public class SingletonHungryModelTest {
	@Test
	public void singleton1() {
		Thread[] threads = new Thread[10];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(SingletonHungryModel.getInstance().hashCode());
				}
			});
		}

		for (int j = 0; j < threads.length; j++) {
			threads[j].start();
		}

	}
}