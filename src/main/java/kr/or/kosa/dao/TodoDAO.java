package kr.or.kosa.dao;

import kr.or.kosa.model.TodoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoDAO {
    List<TodoVO> todoList();
    int todoInsert(TodoVO todoVO);
    int todoUpdate(TodoVO todoVO);
    int todoDelete(TodoVO todoVO);
}
