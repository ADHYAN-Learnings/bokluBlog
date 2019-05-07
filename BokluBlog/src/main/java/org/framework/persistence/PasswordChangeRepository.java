package org.framework.persistence;

import org.framework.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PasswordChangeRepository extends JpaRepository<UserRegistration,Long> {

	@Modifying
	@Query(" UPDATE  UserRegistration u set u.password=?1 where u.email=?2 ")
	void savePassword(String password, String logname);
}
