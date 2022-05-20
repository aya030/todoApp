import './App.css';
import React, { useState } from "react";
import axios from "axios";
import {
	ChakraProvider,
	Button,
	Input,
	Flex,
	Box,
	Center,
	Text
} from '@chakra-ui/react'

function App() {

	const [todos, setTodos] = React.useState(null);
	const [createTodo, setCreateTodo] = useState("");
	const [updateId, setUpdateId] = useState("");
	const [updateTodo, setUpdateTodo] = useState("");

	React.useEffect(() => {
		axios.get("/todos").then(response => {
			setTodos(response.data);
		}, []).catch(error => {
			console.error(error);
		});
	});

	const onCreate = () => {
		axios.post("/todo",
			{
				title: createTodo
			}
		)
	}

	const onChange = (id, title) => {
		setUpdateId(id)
		setUpdateTodo(title)
	}

	const onUpdate = (id) => {
		axios.put(`/todo/id=${id}`,
			{
				id: updateId,
				title: updateTodo
			}
		)
	}

	const onDelete = (id) => {
		axios.delete(`todo/id=${id}`)
	}

	return (
		<ChakraProvider
			width="700px">
			<Text fontSize='sm' align='center' mt='60px'>SpringBoot & React</Text>
			<Text fontSize='xl' align='center'>Todo App</Text>
			<Center>
				<Box
					width='630px'
					mt='40px'>
					<form onSubmit={onCreate}>
						<Flex>
							<Input
								width='530px'
								mb='40px'
								type="text"
								name="issue"
								value={createTodo}
								placeholder="Create Todo"
								onChange={e => setCreateTodo(e.target.value)}
							/>
							<Button
								width='80px'
								colorScheme='blue'
								ml='20px'
								type="submit"
							>
								Create
							</Button>
						</Flex>
					</form>

					<form>
						<Flex
							width='630px'>
							<Input
								width='80px'
								mr='20px'
								type="text"
								name="updateId"
								value={updateId}
								placeholder="id"
								onChange={e => setUpdateId(e.target.value)}
							/>
							<Input
								width='430px'
								type="text"
								name="updateTitle"
								value={updateTodo}
								placeholder="Update Todo"
								onChange={e => setUpdateTodo(e.target.value)}
							/>
							<Button
								width='80px'
								colorScheme='teal'
								variant='outline'
								border='2px'
								ml='20px'
								onClick={() => onUpdate(updateId)}
							>
								Update
							</Button>
						</Flex>
					</form>

					<Box
						mt='40px'>
						{todos?.map((todo) => {
							return (
								<Flex
									mb='20px'>
									<Flex
										width='450px'>
										<p class="todo-id">{todo.id}</p>
										<p class="todo-title">{todo.title}</p>
									</Flex>
									<Box>
										<Button
											width='80px'
											colorScheme='teal'
											variant='outline'
											border='2px'
											mr='20px'
											onClick={() => onChange(todo.id, todo.title)}
										>
											Update
										</Button>
										<Button
											width='80px'
											colorScheme='teal'
											onClick={() => onDelete(todo.id)}
										>
											Done
										</Button>
									</Box>
								</Flex>

							);
						})}

					</Box>
				</Box>
			</Center>
		</ChakraProvider>
	);
}

export default App;
