package lecture.c05core;

import lombok.Data;

@Data
public class Servlet {
	private Dao dao;
	
	public void doget() {
		dao.insert();
	}
}
