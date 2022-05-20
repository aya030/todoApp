# todoApp
Java/SpringBootとReactのTodoApp

https://user-images.githubusercontent.com/101713134/169451210-166f52a4-d0d8-4094-89e3-98fc9b5a3410.mov

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
・Todoを登録　　input[CreateTodo]→　button[Create]<br>
・Todoを更新　　Todo横のbutton[Update]を押すと上のinputにidとtodoが入力される<br>input[UpdateTodo]→　button[Update]<br>
・Todoを削除　　Todo横のbutton[Done]を押すと削除される

## API　URL
| 画面名／機能名 | URL | method | Controller method | 
| ------------ | ------------- | ------------- | ------------- | 
| Todoリスト一覧画面 | /todos | GET | index() | 
| 新規追加 | /todo | POST | create() | 
| Todo更新 | /todo/id={id} | PUT | update() | 
| Todo削除 | /todo/id={id} | Delete | delete() | 
