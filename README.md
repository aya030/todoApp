# todoApp
Java/SpringBootとReactのTodoApp

https://user-images.githubusercontent.com/101713134/169201977-8715e706-c6d8-479c-a107-440482f424cb.mov

todoを登録、更新、削除のできるCRUDアプリ
バックエンドはJava、フロントエンドはReact

## Dependency
backendAPI
Java11
SpringBoot
MyBatis2.2.2

Frontend
React18
chakra-ui

## Usage
・Todoを登録　　input[新しいTodoを入力してね]→　button[作成]<br>
・Todoを更新　　Todo横のbutton[更新]を押すと上のinputにidとtodoが入力される<br>input[新しいTodoを入力してね]→　button[更新]<br>
・Todoを削除　　Todo横のbutton[完了]を押すと削除される

## API　URL
| 画面名／機能名 | URL | method | Controller method | 
| ------------ | ------------- | ------------- | ------------- | 
| Todoリスト一覧画面 | /todos | GET | index() | 
| 新規追加 | /todo | POST | create() | 
| Todo更新 | /todo/id={id} | PUT | update() | 
| Todo削除 | /todo/id={id} | Delete | delete() | 
