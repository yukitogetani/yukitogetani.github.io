package testalgo;

import testInterface.PoriforfizmTest;
import form.Testfinputform;

public class algoTest2 implements PoriforfizmTest {

	public void logic(Testfinputform form)  {
		form.setOutput(form.getName() + "かきくけこ");
		System.out.println(form.getName() + "かきくけこ");

	}
}
