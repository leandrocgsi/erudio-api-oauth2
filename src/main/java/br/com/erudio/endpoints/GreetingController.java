package br.com.erudio.endpoints;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Greeting;
import br.com.erudio.model.User;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@AuthenticationPrincipal User user) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, user.getName()));
	}

}
