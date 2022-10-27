package Kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguage")
public class ProgrammingLanguageController {

	private ProgrammingLanguageService languageService;

	@Autowired
	public ProgrammingLanguageController(ProgrammingLanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return languageService.getAll();
	}

	@GetMapping("/{id}")
	public ProgrammingLanguage getById(@PathVariable(name = "id") int id) throws Exception {
		return languageService.getById(id);

	}

	@PostMapping("/{id}")
	public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		languageService.add(programmingLanguage);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws Exception {
		languageService.delete(id);
	}

	@PutMapping("/{id}")
	public void update(@RequestBody ProgrammingLanguage programmingLanguage, @PathVariable int id) throws Exception {
		languageService.update(programmingLanguage, id);
	}
}
