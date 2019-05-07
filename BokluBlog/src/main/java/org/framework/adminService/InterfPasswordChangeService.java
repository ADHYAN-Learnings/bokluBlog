package org.framework.adminService;

import org.framework.model.PasswordChange;

public interface InterfPasswordChangeService {
	
	void savePassword(PasswordChange passwordChange,String logname);

}
