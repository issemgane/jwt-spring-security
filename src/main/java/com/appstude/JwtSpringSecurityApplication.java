package com.appstude;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.appstude.dao.RoleRepository;
import com.appstude.dao.TaskRepository;
import com.appstude.dao.UserRepository;
import com.appstude.entities.AppRole;
import com.appstude.entities.AppUser;
import com.appstude.entities.Task;
import com.appstude.service.AccountService;

@SpringBootApplication
public class JwtSpringSecurityApplication implements CommandLineRunner {
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private AccountService accountService;

	
	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecurityApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBCPE  (){
		return   new BCryptPasswordEncoder();
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		accountService.addUser(new AppUser(null, "admin", "1234", null));
		accountService.addUser(new AppUser(null, "user", "1234", null));
		
		accountService.addRole(new AppRole(null, "ADMIN"));
		accountService.addRole(new AppRole(null, "USER"));
		
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "USER");
		
		
		
		Stream.of("T1","T2","T3","T4").forEach(t->{
			taskRepository.save(new Task(null,t));
		});
		
		Stream.of("T1","T2","T3","T4").forEach(t->{
			taskRepository.save(new Task(null,t));
		});
		
		taskRepository.findAll().forEach(t->{
			System.out.println("************* : "+t.getTaskName());
		});
		
	
		
	}
}
