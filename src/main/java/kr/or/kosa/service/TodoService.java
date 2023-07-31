package kr.or.kosa.service;


import kr.or.kosa.dao.TodoDAO;
import kr.or.kosa.model.TodoVO;
import kr.or.kosa.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TodoService {
    private TodoDAO todoDAO;

    @Autowired
    public TodoService(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    public int todoInsert(TodoVO todoVO) {
        int result = todoDAO.todoInsert(todoVO);
        return todoVO.getId();
    }
    public void bulkInsert () {
        TodoVO todoVO = new TodoVO();
        for(int i = 0 ; i < 2500 ; i++){
            todoVO.setTitle("리액트의 기초 알아보기 할일 " + i);
            todoVO.setChecked(i%3==0?'Y':'N');
            todoDAO.todoInsert(todoVO);
            try {
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (Exception e) {
            }
        }
    }

    public List<TodoVO> todoList(Users users) {
        return todoDAO.todoList(users);
    }

    public int todoUpdate(TodoVO todoVO){
        int result = todoDAO.todoUpdate(todoVO);
        return result;
    }

    public int todoDelete(TodoVO todoVO){
        int result = todoDAO.todoDelete(todoVO);
        return result;
    }
}
