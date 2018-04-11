package assignment10;

public interface StudentsPersistor {
	void save(StudentsManager manager) throws Exception;

	StudentsManager load() throws Exception;
}
