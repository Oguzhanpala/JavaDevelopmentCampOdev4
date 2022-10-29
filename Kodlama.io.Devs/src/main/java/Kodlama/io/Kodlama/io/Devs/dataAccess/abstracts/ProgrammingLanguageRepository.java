package Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {

	List<ProgrammingLanguage> getAll();

	ProgrammingLanguage getById(int id);

	void add(ProgrammingLanguage programmingLanguage);

	void delete(int id) throws Exception;

	void update(ProgrammingLanguage programmingLanguage);

}
