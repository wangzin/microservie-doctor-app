package bt.hospital;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DoctorLoginAdminApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DoctorLoginAdminApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
