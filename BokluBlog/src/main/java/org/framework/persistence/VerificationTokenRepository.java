/**
 * 
 */
package org.framework.persistence;

import org.framework.model.VerficationToken;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Aditya
 *
 */
public interface VerificationTokenRepository extends JpaRepository<VerficationToken, Long> {
	
	VerficationToken findByToken(String token);
}
