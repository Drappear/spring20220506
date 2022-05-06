package lecture.b02lombok;

import lombok.extern.log4j.Log4j;

@Log4j
public class App {
	public static void main(String[] args) {
		System.out.println("메세지 출력");
		log.debug("log debug message");
		log.info("log info message");
		log.warn("log warn message");
		log.error("log error message");
		log.fatal("log fatal message");
	}
}
