package app;

public class App {
	
	public static void main(String[] args) {
		
		//load preferences

		Window window = Window.getInstance();
		window.setPreferencesOnLoad();

	}

}
