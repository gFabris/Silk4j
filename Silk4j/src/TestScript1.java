import com.borland.silktest.jtf.BrowserBaseState;
import com.borland.silktest.jtf.Desktop;
import org.junit.Before;
import org.junit.Test;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;
import com.borland.silktest.jtf.common.types.MouseButton;
import com.borland.silktest.jtf.common.types.Point;
import com.borland.silktest.jtf.xbrowser.DomLink;

public class TestScript1 {
	
	private Desktop desktop = new Desktop();
	//libSilk lib = new libSilk();

	@Before
	public void baseState() {
		// Go to web page 'sac.rsinet.com.br'
		BrowserBaseState baseState = new BrowserBaseState();
		baseState.execute(desktop);
	}

	/*
	@Test
	public void mainScript2() {
		

		lib.TypeKeys("//INPUT[@id='gs_htif0']", "rsi");
		lib.Click("//A[@textContents='RSI']");
		
		
		lib.TypeKeys("//INPUT[@name='username2']", "guilherme.fabris");
		lib.TypeKeys("//INPUT[@name='password']", "asdfg123");
		//lib.Click("//INPUT[@Value='Entrar']");

		 desktop.<DomTextField> find("sac_rsinet_com_br.BrowserWindow.username")
		.typeKeys("guilherme.fabris<#Enter>");
		
	}*/

	@Test
	public void mainScript() {
		desktop.<DomTextField> find("//BrowserApplication//BrowserWindow//DIV[@id='gs_lc0']/INPUT")
				.typeKeys("RSI<Enter>");
		desktop.<DomLink> find("//BrowserApplication//BrowserWindow//A[@textContents='RSI']").click(
				MouseButton.LEFT, new Point(17, 5));
		desktop.<DomLink> find("//BrowserApplication//BrowserWindow//A[@textContents='Conduta e Ética']")
				.click(MouseButton.LEFT, new Point(125, 10));
		//String output = desktop.<DomLink> find("//BrowserApplication//BrowserWindow//STRONG[@textContents='Código de Conduta e *']").getProperty("Text").toString();
		//System.out.println(output);
	}
}