import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.common.types.MouseButton;
import com.borland.silktest.jtf.common.types.Point;
import com.borland.silktest.jtf.xbrowser.DomTextField;

public class libSilk {
	private Desktop desktop = new Desktop();
	private int timeToWaitObject = 2;
	boolean highLight = true;
	private String evidencePath = "c:\teste";
	private int stepNumber = 0;
	private String caseName;
	
	
	void Click(String xpath) {
		desktop.<DomTextField> find("//BrowserApplication//BrowserWindow" + xpath)
		.click(MouseButton.LEFT, new Point(10, 10));
	}
	
	public void TypeKeys(String xpath, String value) {
		//WaitElement(xpath);
		desktop.<DomTextField> find("//BrowserApplication//BrowserWindow" +xpath)
		.typeKeys(value);
	}
	
	public Boolean Exists(String xpath){
		if (highLight){
			try {
				desktop.<DomTextField> find("//BrowserApplication//BrowserWindow" +xpath)
				.highlightObject();
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return desktop.<DomTextField> find("//BrowserApplication//BrowserWindow" +xpath).exists();
		}
	}	
	
	private Boolean WaitElement(String xpath){
		int tentativas = 0;
		while(!Exists(xpath) & tentativas > 10 ){
			System.out.println("entrou no tratamento");
			tentativas = tentativas +1;
			try {
				Thread.sleep(timeToWaitObject * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			if (tentativas > 10){
				return false;
			} else {
				return true;
			}
	}
	
	public String GetProperty(String xpath, String property){
		
		return desktop.<DomTextField> find("//BrowserApplication//BrowserWindow" +xpath)
		.getProperty(property).toString();
	}
	
	
	private void TakeEvidence(String xpath){
		desktop.<DomTextField> find("//BrowserApplication//BrowserWindow" +xpath)
		.captureBitmap(evidencePath + EvidenceName() + ".PNG");
	}

	
	private String EvidenceName() {
		stepNumber = stepNumber + 1;
		return caseName + "_" + stepNumber + "_" + "implementar função de hora e data";
	}
}