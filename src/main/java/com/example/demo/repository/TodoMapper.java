package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Todo;


@Mapper
public interface TodoMapper {
	// 全件取得
	public List<Todo> findAll();

	// 1件取得
	public Optional<Todo> findById(int id);

	// 登録
	public void insertOne(Todo todo);

	// 更新
	public void updateOne(@Param("id") int id, @Param("title") String title);

	// 削除
	public Integer deleteOne(int id);

}