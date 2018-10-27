package com.dev.caps.model;

import com.dev.caps.beans.Person;

public interface PersonDAO {
	public void create(Person person);
	public void update();
	public void delete();
	public void search(int perId);

}
