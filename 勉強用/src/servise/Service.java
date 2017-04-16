package servise;

import testInterface.PoriforfizmTest;
import form.Testfinputform;

public class Service {

	private PoriforfizmTest poriTest;

	public void setPoriTest(PoriforfizmTest poriTest) {
		this.poriTest = poriTest;
	}

	public void doprocess(Testfinputform form) {
		// 処理実行の橋渡し役
		System.out.println("テスト開始");
		// PoriforfizmTestインターフェースを実現しているものであれば何でもいけるよ。（ポリモーフィズム）
		this.poriTest.logic(form);
		System.out.println("テスト終了");
	}
}
