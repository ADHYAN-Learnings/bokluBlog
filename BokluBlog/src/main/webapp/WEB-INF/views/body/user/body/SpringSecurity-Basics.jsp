 <html>
   <body class="">
      <div class="container-fluid margin-top-6">
        <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8 offset-xs-2 offset-sm-2 offset-md-2 offset-lg-2 bg-light">
         
       <h1>Spring Security - Basics</h1>
       
         <div>In this article we'll talk about spring security from the base. For that purpose I have created a 
          <span class="underline">CRUD</span> application with the the help of following technologies.</div>
          <br/>
           <ol>
             <li>MySql</li>
             <li>Spring Boot</li>
             <li>Java 8</li>
             <li>JPA</li>
           </ol>
           <br/>
           <p class="underline font-weight-bold h4">Project Structure</p>
            <img src="<spring:url value='/images/SpringSecurity/ProjectStructure.PNG'/>" alt="Image Preview not Available" class="img-fluid img-square">
            <br/>
            <br/>
           <p class="underline font-weight-bold h4">pom.xml</p>
           <pre class="bg-light"><code>
&lt;?xml version="1.0" encoding="UTF-8"?&gt;
&lt;project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"&gt;
	&lt;modelVersion&gt;4.0.0&lt;/modelVersion&gt;
	&lt;parent&gt;
		&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
		&lt;artifactId&gt;spring-boot-starter-parent&lt;/artifactId&gt;
		&lt;version&gt;2.1.3.RELEASE&lt;/version&gt;
		&lt;relativePath/&gt; &lt;!-- lookup parent from repository --&gt;
	&lt;/parent&gt;
	&lt;groupId&gt;com.security&lt;/groupId&gt;
	&lt;artifactId&gt;SpringSecurityBasics&lt;/artifactId&gt;
	&lt;version&gt;0.0.1-SNAPSHOT&lt;/version&gt;
	&lt;name&gt;SpringSecurityBasics&lt;/name&gt;
	&lt;description&gt;Demo project for Spring Boot&lt;/description&gt;

	&lt;properties&gt;
		&lt;java.version&gt;1.8&lt;/java.version&gt;
	&lt;/properties&gt;

	&lt;dependencies&gt;
		 &lt;dependency&gt;
			&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
			&lt;artifactId&gt;spring-boot-starter-data-jpa&lt;/artifactId&gt;
		&lt;/dependency&gt; 
		 &lt;dependency&gt;
			&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
			&lt;artifactId&gt;spring-boot-starter-security&lt;/artifactId&gt;
		&lt;/dependency&gt; 
		&lt;dependency&gt;
			&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
			&lt;artifactId&gt;spring-boot-starter-web&lt;/artifactId&gt;
		&lt;/dependency&gt;

		&lt;dependency&gt;
			&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
			&lt;artifactId&gt;spring-boot-devtools&lt;/artifactId&gt;
			&lt;scope&gt;runtime&lt;/scope&gt;
		&lt;/dependency&gt;
		&lt;dependency&gt;
			&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
			&lt;artifactId&gt;spring-boot-starter-test&lt;/artifactId&gt;
			&lt;scope&gt;test&lt;/scope&gt;
		&lt;/dependency&gt;
		&lt;dependency&gt;
			&lt;groupId&gt;org.springframework.security&lt;/groupId&gt;
			&lt;artifactId&gt;spring-security-test&lt;/artifactId&gt;
			&lt;scope&gt;test&lt;/scope&gt;
		&lt;/dependency&gt;
		&lt;dependency&gt;
            &lt;groupId&gt;org.apache.tomcat.embed&lt;/groupId&gt;
            &lt;artifactId&gt;tomcat-embed-jasper&lt;/artifactId&gt;
            &lt;scope&gt;provided&lt;/scope&gt;
        &lt;/dependency&gt;
        &lt;dependency&gt;
            &lt;groupId&gt;mysql&lt;/groupId&gt;
            &lt;artifactId&gt;mysql-connector-java&lt;/artifactId&gt;
            &lt;scope&gt;runtime&lt;/scope&gt;
        &lt;/dependency&gt;
        
         &lt;dependency&gt;
            &lt;groupId&gt;javax.servlet&lt;/groupId&gt;
            &lt;artifactId&gt;jstl&lt;/artifactId&gt;
        &lt;/dependency&gt;
	&lt;/dependencies&gt;

	&lt;build&gt;
		&lt;plugins&gt;
			&lt;plugin&gt;
				&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
				&lt;artifactId&gt;spring-boot-maven-plugin&lt;/artifactId&gt;
			&lt;/plugin&gt;
		&lt;/plugins&gt;
	&lt;/build&gt;

&lt;/project&gt;

            
           </code></pre>
           <br/>
           <br/>
            <p class="underline font-weight-bold h4">HelloController.java</p>
            <pre class="bg-light">
             <code >
package com.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.model.AddUserModel;
import com.spring.service.InterfSaveService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

@Autowired	
private InterfSaveService interfSaveService;

	@GetMapping("/")
	public String userTable(Model model) {
		List&lt;AddUserModel&gt; displayUserModel = interfSaveService.getUserDetails();
		model.addAttribute("displayUserModel", displayUserModel);
		return "SpringSecurityTable";
	}
	
	@GetMapping("/addUser")
	public String createNewUser(Model model) {
		model.addAttribute("addUserModel", new AddUserModel());
		return "addUser";
	}
	
	@PostMapping("/save")
	public String saveNewUser(@Valid AddUserModel addUserModel ,BindingResult bindingResult , Model model) {
		interfSaveService.saveModel(addUserModel);
		List&lt;AddUserModel&gt; displayUserModel = interfSaveService.getUserDetails();
		
		model.addAttribute("displayUserModel",displayUserModel );
		
		return "SpringSecurityTable";
	}
	
   @GetMapping("/delete")
   public String deleteUser(@RequestParam("id") Long id,Model model) {
	   
	   interfSaveService.deleteUser(id);
	    List&lt;AddUserModel&gt; displayUserModel = interfSaveService.getUserDetails();
		model.addAttribute("displayUserModel",displayUserModel );
	   return "SpringSecurityTable";
   }
   
   @GetMapping("/edit")
   public String editUser(@RequestParam("id") Long id,Model model) {
	   List&lt;AddUserModel&gt; displayUserModel = interfSaveService.getUserDetails();
	    Long editId = id;
		model.addAttribute("displayUserModel",displayUserModel );
		model.addAttribute("editId",editId);
		 return "SpringSecurityTable";
   }
   
   @PostMapping("/saveModifiedData")
   public String updateData(@RequestParam("id") Long id,@Valid AddUserModel addUserModel ,BindingResult bindingResult , Model model) {

	   interfSaveService.saveModel(addUserModel);
	   
	   List&lt;AddUserModel&gt; displayUserModel = interfSaveService.getUserDetails();
	   model.addAttribute("displayUserModel",displayUserModel );
	   return "SpringSecurityTable";
   }

}
              
             </code>
            </pre>
            <br/>
           <br/>
            <p class="underline font-weight-bold h4">AddUserModel.java</p>
            <pre class="bg-light">
             <code>
package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;

@Entity
public class AddUserModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;	
     
	@NotNull(message="First Name is Required.")
	@NotEmpty(message="First Name is Required.")
	private String firstName;
	
	@NotNull(message="Last Name is Required.")
	@NotEmpty(message="Last Name is Required.")
	private String lastName;
	
	@Email
	@NotNull(message="Email is Required.")
	@NotEmpty(message="Email is Required.")
	private String email;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AddUserModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	
	

}
             
             </code>
            </pre>
            <br/>
            <br/>
             <p class="underline font-weight-bold h4">AddUserModelRepository.java</p>
             <img src="/images/SpringSecurity/AddUserModelRepository.PNG" alt="Image Preview not Available" class="img-fluid img-square">
            <br/>
            <br/>
              <p class="underline font-weight-bold h4">SpringSecurityBasicsApplication.java</p>
              <img src="/images/SpringSecurity/SpringSecurityApplication.PNG" alt="Image Preview not Available" class="img-fluid img-square">
            <br/>
            <br/>
              <p class="underline font-weight-bold h4">InterfSaveService.java</p>
              <img src="/images/SpringSecurity/InterfSaveService.PNG" alt="Image Preview not Available" class="img-fluid img-square">
               <br/>
               <br/>
              <p class="underline font-weight-bold h4">SaveService.java</p>
               <img src="/images/SpringSecurity/SaveService.PNG" alt="Image Preview not Available" class="img-fluid img-square">
              <br>
              <br>
               <p class="underline font-weight-bold h4">application.properties</p>
                <img src="/images/SpringSecurity/applicationProperties.PNG" alt="Image Preview not Available" class="img-fluid img-square">
                
                <br/>
                <br/>
                <div>In application.properties you can see that I am using the database name <span class="underline">springsecurity</span>.
                 If you want you can change the database name according to your requirement.</div>
                 <br/>
                 <div>When you will load this project,  spring security will load the default login page which is provided by spring people. For
                  that default page we are providing username and password in application.properties file.</div>
                  <br/>
                  <br/>
                  <div>Run the springSecurityBasicApplication.java file and enter the following link:-<span class="underline">localhost:8080</span>.</div>
                  <br/>
                  <img src="/images/SpringSecurity/SpringSecurityDefaultLogin.PNG" alt="Image Preview not Available" class="img-fluid img-square">
                  <br/>
                  <br/>
                  <div>Enter the username and password which you have mentioned in the following application.properties File. 
                  After that landing page will come which you have designed.</div>
                  <br/>
                   <img src="/images/SpringSecurity/landingPage.PNG" alt="Image Preview not Available" class="img-fluid img-square">
                   <br/>
                   <br/>
                   <div>You can download the project from the <a href="https://github.com/boklu-aditya/spring-security-Basics.git">Github</a>Link and the sql file inside resources folder.</div>
                   <br>
                  
        </div>
      </div>
   </body>
 </html>