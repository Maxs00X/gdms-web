package com.oracle.gdms.dao;

import com.oracle.gdms.entity.UserModel;

public interface UserDao {
	int add(UserModel user);

	UserModel login(UserModel user);

	int hasMobile(String mobile);
}
