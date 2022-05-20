package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoMapper;


@Service
@Transactional
public class TodoService {
	private final TodoMapper todoMapper;

	public TodoService(TodoMapper todoMapper) {
		this.todoMapper = todoMapper;
	}

	// 全件取得
	public List<Todo> getTodoList() {
		return todoMapper.findAll();
	}

	// 1件取得
	public Optional<Todo> findById(int id) {
		return todoMapper.findById(id);
	}

	// 新規登録
	public void insertOne(@Validated Todo todo) {
	  todoMapper.insertOne(todo);
	}

	// 更新
	public void updateOne(int id, String title) {
		todoMapper.updateOne(id, title);
	}

	// 削除
	public void deleteOne(int id) {
		todoMapper.deleteOne(id);
	}

}
