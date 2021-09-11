package dev.mai.repositories;

import dev.mai.models.Employee;
import dev.mai.models.Form;

public interface FormRepo {
	
	public Form addForm(Form f, Employee e);
	public Form getForm(int id);
	public Form updateForm(Form changeF);

}
