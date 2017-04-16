package testalgo;

import testInterface.PoriforfizmTest;
import form.Testfinputform;

public class algoTest1 implements PoriforfizmTest {

	public void logic(Testfinputform form) {
		form.setOutput(form.getName() + "あいうえお");
		System.out.println(form.getName() + "あいうえお");

	}
}
