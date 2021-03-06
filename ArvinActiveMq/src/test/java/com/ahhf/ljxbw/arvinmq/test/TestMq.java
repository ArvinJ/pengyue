package com.ahhf.ljxbw.arvinmq.test;
/**
 * 
 * @ClassName:  TestMq   
 * @Description:TODO(生产者开始生产消息)   
 * @author: wenjin.zhu
 * @date:   2018年4月2日 下午2:53:58
 */
public class TestMq {
	public static void main(String[] args) {
		Producter producter = new Producter();
		producter.init();
		TestMq testMq = new TestMq();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Thread 1
		new Thread(testMq.new ProductorMq(producter)).start();
		// Thread 2
		new Thread(testMq.new ProductorMq(producter)).start();
		// Thread 3
		new Thread(testMq.new ProductorMq(producter)).start();
		// Thread 4
		new Thread(testMq.new ProductorMq(producter)).start();
		// Thread 5
		new Thread(testMq.new ProductorMq(producter)).start();
	}

	private class ProductorMq implements Runnable {
		Producter producter;

		public ProductorMq(Producter producter) {
			this.producter = producter;
		}

		public void run() {
			while (true) {
				try {
					producter.sendMessage("Jaycekon-MQ");
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}