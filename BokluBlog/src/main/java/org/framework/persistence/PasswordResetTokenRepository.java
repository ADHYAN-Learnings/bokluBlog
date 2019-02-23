package org.framework.persistence;

import org.framework.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

	PasswordResetToken findByToken(String token);
}
