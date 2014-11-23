package models;

import play.Logger;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Gpio {
	static GpioController gpio = null;
	static GpioPinDigitalOutput myLed = null;
	static boolean led = false;

	static {
		try {
			gpio = GpioFactory.getInstance();
			myLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "My LED", PinState.LOW);
		} catch (Error e) {
			Logger.info("No GPIO available");
		}
	}

	public static void setLed(boolean on) {
		led = on;
		if (gpio != null) {
			PinState pinState = on ? PinState.HIGH : PinState.LOW;
			myLed.setState(pinState);
		} else {
			Logger.info("No gpio available - LED now should be " + on);
		}
	}

	public static void toggleLed() {
		led = !led;
		setLed(led);
	}
}
