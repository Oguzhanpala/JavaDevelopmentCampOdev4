package Kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository languageRepository;

	public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {

		return languageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) throws Exception {

		return languageRepository.getById(id);
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		
/*		for (ProgrammingLanguage pLanguage : getAll()) {
			if (programmingLanguage.getName().equals(pLanguage.getName())) {
				throw new Exception("İsim zaten kayıtlıdır.");
			}	
		}
		for (ProgrammingLanguage pLanguage : getAll()) {
			if (programmingLanguage.getId()==pLanguage.getId()) {
				throw new Exception("Girilen id kayıtlıdır.");
			}
		}
		if (programmingLanguage.getName().isEmpty()) {
			throw new Exception("İsim boş geçilemez");
		}  																								*/
		
		if (isIdExist(programmingLanguage.getId())) {
			throw new Exception("Girilen id kayıtlı");
		}
		if (isNameExist(programmingLanguage) || programmingLanguage.getName().isEmpty()) {
			throw new Exception("Girilen isim kayıtlı yada değer girilmemiş");
		}
		languageRepository.add(programmingLanguage);

	}

	@Override
	public void delete(int id) throws Exception {
		languageRepository.delete(id);

	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage, int id) throws Exception {
		if (!isIdExist(programmingLanguage.getId())) {
			throw new Exception("Geçersiz id");
		}
		if (isNameExist(programmingLanguage)) {
			throw new Exception("Girilen isim kayıtlı");
		}
		languageRepository.update(programmingLanguage,id);

	}
	/*------------- Bir kere yaz her yerde kullan DO NOT REPEAT YOURSELF-----------*/
	public boolean isNameExist(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage language : getAll()){
			if (language.getName().equals(programmingLanguage.getName())) {
				return true;
			}
		}
		return false;
	}
	/*------------- Bir kere yaz her yerde kullan DO NOT REPEAT YOURSELF-----------*/
	public boolean isIdExist(int id) {
		for (ProgrammingLanguage language : getAll()) {
			if (language.getId()==id) {
				return true;
				
			}
			
		}
		return false;
	}

}