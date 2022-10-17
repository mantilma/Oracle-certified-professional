package ocp.chapter5.date;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Zoo2_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"saluto", "HELLO2, {0}" },
			{"apertura", "OPEN2"},
			{"oggetto", new Object()}
		};
	}
}
