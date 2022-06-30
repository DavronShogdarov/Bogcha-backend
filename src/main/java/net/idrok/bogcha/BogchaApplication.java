package net.idrok.bogcha;

import net.idrok.bogcha.entity.Role;
import net.idrok.bogcha.entity.User;
import net.idrok.bogcha.repository.UserRepository;
import net.idrok.bogcha.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
	
import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
public class BogchaApplication {
	public static void main(String[] args) {
		SpringApplication.run(BogchaApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	final Logger LOG = LoggerFactory.getLogger(BogchaApplication.class.getName());

	@Autowired
	PasswordEncoder encoder;

	@PostConstruct
	public void birlamchiAdminlarniBelgilash() {

		if (userRepository.findByLogin("admin123").isEmpty()) {
			User user = new User();
			user.setIsm("Administrator");
			user.setLogin("admin123");
			user.setParol(encoder.encode("admin123"));
			user.setAktiv(true);
			user.setRegVaqt(LocalDateTime.now());
			user.setRole(Role.ADMIN);
			userRepository.save(user);
		}
	}

	@Autowired
	JwtUtil jwtUtil;

	@PostConstruct
	public void jwtSinov() {
		LOG.info("----------------");
		String token = jwtUtil.generateToken("admin123", "admin");
		LOG.info(token);
		LOG.info("----------------");
		LOG.info("Haqiqiy: " + jwtUtil.validateToken(token));
		LOG.info("Login: " + jwtUtil.getLogin(token));
		LOG.info("Role: " + jwtUtil.getRole(token));

	}

}
