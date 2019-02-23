/**
 * 
 */
package org.framework.persistence;

import org.framework.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aditya
 *
 */
public interface UserRepository extends JpaRepository<UserRegistration, Long> {
	
	UserRegistration findByEmail(String email);

}
