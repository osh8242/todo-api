package kr.or.kosa.controller;

import kr.or.kosa.service.TodoService;
import kr.or.kosa.model.TodoVO ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;
    @Autowired
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("/hello")
    public String hello() {
        System.out.println("TestController.hello()");
        return "Hello World!!";
    }

    @PostMapping("/hello")
    public String helloPost(@RequestParam("title") String title) {

        System.out.println("TestController.helloPost");
        System.out.println("title = " + title);

        return "Post response";
    }

    @GetMapping("/todoSampleDataGen")
    public String todoSampleDataGen() {
        System.out.println("TestController.todoSampleDataGen");
        todoService.bulkInsert();
        return "OK";
    }

    @GetMapping("/todoList")
    public ResponseEntity<List<TodoVO>> todoList(){
        System.out.println("TestController.todoList");
        List<TodoVO> todoList = todoService.todoList();
        return ResponseEntity.ok(todoList);
    }

    @PostMapping("/todoInsert")
    public ResponseEntity<Integer> insert(@RequestBody TodoVO todoVO){
        System.out.println("TestController.todoInsert");
        System.out.println("todoVO = " + todoVO);
        int result = todoService.todoInsert(todoVO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/todoUpdate")
    public ResponseEntity<Integer> update(@RequestBody TodoVO todoVO){
        System.out.println("TestController.todoUpdate");
        int result = todoService.todoUpdate(todoVO);
        System.out.println("insert result = " + result);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/todoDelete")
    public ResponseEntity<Integer> delete(@RequestBody TodoVO todoVO){
        System.out.println("TestController.todoDelete");
        int result = todoService.todoDelete(todoVO);
        return ResponseEntity.ok(result);
    }
}
