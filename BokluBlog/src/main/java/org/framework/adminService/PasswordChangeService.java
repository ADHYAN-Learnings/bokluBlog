package org.framework.adminService;

import org.framework.model.PasswordChange;
import org.framework.persistence.PasswordChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class PasswordChangeService implements InterfPasswordChangeService {
	
	@Autowired
	private PasswordChangeRepository passwordChangeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void savePassword(final PasswordChange passwordChange,String logname) {
		passwordChangeRepository.savePassword(passwordEncoder.encode(passwordChange.getNewPassword()), logname);
	}

}
