package controllers;

import models.Gpio;
import play.mvc.Controller;
import play.mvc.Result;

public class Api extends Controller {

	public static Result setLed(boolean on) {
		Gpio.setLed(on);
		return ok();
	}

	public static Result toggleLed() {
		Gpio.toggleLed();
		return ok();
	}
}
