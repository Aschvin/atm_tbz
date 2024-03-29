package ch.nyp.atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtmApplication {

	public static void main(String[] args) {
		disableStandardErrorStream();

		SpringApplication.run(AtmApplication.class, args);
	}

	/**
	 * Closes the standard error-stream System.err. This disables the message <br><span style="color: red">WARNING: An illegal reflective access operation has occurred</span><br>
	 * which is put out by the JVM due to the Jackson ObjectMapper
	 */
	private static void disableStandardErrorStream() {
		System.err.close();
	}
}
