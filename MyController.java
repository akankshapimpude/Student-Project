package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MyController {

	@Autowired
	StudentRepo srepo;
	
	@RequestMapping("save")
	public List<Student> saveUpdate(@RequestBody Student student)
	{
		System.out.println(student);
		srepo.save(student);
		return srepo.findAll();
	}
	
	@RequestMapping("delete/{id}")
	public List<Student> delete(@PathVariable int id)
	{
		srepo.deleteById(id);
		return srepo.findAll();
	}
	
	@RequestMapping("getAll")
	public List<Student> getall()
	{
		return srepo.findAll();
	}
}