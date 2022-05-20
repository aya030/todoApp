package com.example.demo.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;

@RestController
@Validated
@RequestMapping
public class TodoController {
		private final TodoService todoService;

		public TodoController(TodoService memoService) {
			this.todoService = memoService;
		}

		/* Top */
		@GetMapping("/todos")
		public List<Todo> index() {
			return todoService.getTodoList();
		}

		/* 新規登録 */
		@PostMapping("/todo")
		public void create(@RequestBody Todo todo) {

			todoService.insertOne(todo);
		}

		/* 更新 */
		@GetMapping("/memo/id={id}")
		public void edit(@PathVariable("id") int id) {

			todoService.findById(id).get();

		}

		@PutMapping("/todo/id={id}")
		public void update(Model model,@PathVariable("id") int id,@RequestBody @Validated Todo todo, BindingResult result) {

			todoService.updateOne(id, todo.getTitle());
		}

		/* 削除 */
		@DeleteMapping("/todo/id={id}")
		public void delete(@PathVariable("id") int id) {

			todoService.deleteOne(id);
		}

	}

