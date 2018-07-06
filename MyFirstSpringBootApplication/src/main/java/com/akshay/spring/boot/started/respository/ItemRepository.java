package com.akshay.spring.boot.started.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.akshay.spring.boot.started.entity.UserItem;

public interface ItemRepository extends CrudRepository<UserItem, Integer> {
	public List<UserItem> findByUserName(String userName);
}
